package juice.server.webmvc;

import juice.exception.JuiceServerWebInputException;
import juice.finder.GraphqlDefinitionFinderRegister;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.graphql.server.WebGraphQlHandler;
import org.springframework.graphql.server.WebGraphQlRequest;
import org.springframework.http.MediaType;
import org.springframework.util.AlternativeJdkIdGenerator;
import org.springframework.util.Assert;
import org.springframework.util.IdGenerator;
import org.springframework.util.StringUtils;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;
import reactor.core.publisher.Mono;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class JuiceGraphQlHttpHandler {

		private static final Log logger = LogFactory.getLog(JuiceGraphQlHttpHandler.class);

		private final List<MediaType> SUPPORTED_MEDIA_TYPES =
						Arrays.asList(MediaType.APPLICATION_GRAPHQL, MediaType.APPLICATION_JSON);

		private final ParameterizedTypeReference<Map<String, Object>> MAP_PARAMETERIZED_TYPE_REF =
						new ParameterizedTypeReference<Map<String, Object>>() {
						};

		private final IdGenerator idGenerator = new AlternativeJdkIdGenerator();

		private final WebGraphQlHandler graphQlHandler;
		private final GraphqlDefinitionFinderRegister register;

		public WebGraphQlRequest build(ServerRequest serverRequest) throws ServletException {
				Map<String, Object> body = readBody(serverRequest);
				String graphql = getGraphql(body);
				body.put("query", graphql);

				return new WebGraphQlRequest(
								serverRequest.uri(), serverRequest.headers().asHttpHeaders(), body,
								idGenerator.generateId().toString(), LocaleContextHolder.getLocale());
		}

		private String getGraphql(Map<String, Object> body) {
				if (!StringUtils.hasText((String) body.get("graphqlKey"))) {
						throw new JuiceServerWebInputException("No \"graphqlKey\" in the request document");
				}
				String graphqlKey = String.valueOf(body.get("graphqlKey"));
				return register.getGraphQlDefinition(graphqlKey);
		}

		private Map<String, Object> readBody(ServerRequest request) throws ServletException {
				try {
						return request.body(MAP_PARAMETERIZED_TYPE_REF);
				} catch (IOException ex) {
						throw new JuiceServerWebInputException("I/O error while reading request body", null, ex);
				}
		}

		/**
		 * Create a new instance.
		 *
		 * @param graphQlHandler common handler for GraphQL over HTTP requests
		 */
		public JuiceGraphQlHttpHandler(WebGraphQlHandler graphQlHandler, GraphqlDefinitionFinderRegister register) {
				Assert.notNull(graphQlHandler, "WebGraphQlHandler is required");
				this.graphQlHandler = graphQlHandler;
				this.register = register;
		}

		/**
		 * Handle GraphQL requests over HTTP.
		 * @param serverRequest the incoming HTTP request
		 * @return the HTTP response
		 * @throws ServletException may be raised when reading the request body, e.g.
		 * {@link HttpMediaTypeNotSupportedException}.
		 */
		public ServerResponse handleRequest(ServerRequest serverRequest) throws ServletException {

				WebGraphQlRequest graphQlRequest = this.build(serverRequest);

				if (logger.isDebugEnabled()) {
						logger.debug("Executing: " + graphQlRequest);
				}

				Mono<ServerResponse> responseMono = this.graphQlHandler.handleRequest(graphQlRequest)
								.map(response -> {
										if (logger.isDebugEnabled()) {
												logger.debug("Execution complete");
										}
										ServerResponse.BodyBuilder builder = ServerResponse.ok();
										builder.headers(headers -> headers.putAll(response.getResponseHeaders()));
										builder.contentType(selectResponseMediaType(serverRequest));
										return builder.body(response.toMap());
								});

				return ServerResponse.async(responseMono);
		}

		private MediaType selectResponseMediaType(ServerRequest serverRequest) {
				for (MediaType accepted : serverRequest.headers().accept()) {
						if (SUPPORTED_MEDIA_TYPES.contains(accepted)) {
								return accepted;
						}
				}
				return MediaType.APPLICATION_JSON;
		}

}

