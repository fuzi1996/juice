package juice.config;

import graphql.GraphQL;
import juice.finder.GraphqlDefinitionFinder;
import juice.finder.GraphqlDefinitionFinderRegister;
import juice.finder.impl.StaticGraphqlDefinitionFinder;
import juice.properties.JuiceProperties;
import juice.server.webmvc.JuiceGraphQlHttpHandler;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.graphql.GraphQlAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.core.log.LogMessage;
import org.springframework.graphql.ExecutionGraphQlService;
import org.springframework.graphql.execution.GraphQlSource;
import org.springframework.graphql.server.WebGraphQlHandler;
import org.springframework.graphql.server.webmvc.GraphQlHttpHandler;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.function.*;

import java.util.Collections;

@AutoConfiguration(after = GraphQlAutoConfiguration.class)
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
@ConditionalOnClass({GraphQL.class, GraphQlHttpHandler.class})
@ConditionalOnBean(ExecutionGraphQlService.class)
@EnableConfigurationProperties(JuiceProperties.class)
public class JuiceAutoConfiguration {

		private static final Log logger = LogFactory.getLog(JuiceAutoConfiguration.class);

		private static MediaType[] SUPPORTED_MEDIA_TYPES = new MediaType[]{MediaType.APPLICATION_GRAPHQL,
						MediaType.APPLICATION_JSON};

		@Bean
		public GraphqlDefinitionFinderRegister getGraphqlDefinitionFinderRegister(ObjectProvider<GraphqlDefinitionFinder> finders) {
				GraphqlDefinitionFinderRegister register = new GraphqlDefinitionFinderRegister();
				finders.orderedStream().forEach(register::regist);
				return register;
		}

		@Bean
		public JuiceGraphQlHttpHandler getJuiceGraphQlHttpHandler(WebGraphQlHandler graphQlHandler, GraphqlDefinitionFinderRegister register) {
				return new JuiceGraphQlHttpHandler(graphQlHandler, register);
		}

		@Bean
		@ConditionalOnMissingBean
		public StaticGraphqlDefinitionFinder getStaticGraphqlDefinitionFinder(ObjectProvider<StaticGraphqlDefinitionFinder.StaticGraphqlWrapper> wrappers) {
				StaticGraphqlDefinitionFinder finder = new StaticGraphqlDefinitionFinder();
				wrappers.stream().forEach(finder::addGraphQL);
				return finder;
		}

		@Bean
		@Order(0)
		public RouterFunction<ServerResponse> juiceRouterFunction(JuiceGraphQlHttpHandler httpHandler,
		                                                          GraphQlSource graphQlSource,
		                                                          JuiceProperties properties) {
				String path = properties.getPath();
				logger.info(LogMessage.format("Juice endpoint HTTP POST %s", path));
				RouterFunctions.Builder builder = RouterFunctions.route();
				builder = builder.GET(path, this::onlyAllowPost);
				builder = builder.POST(path, RequestPredicates.contentType(SUPPORTED_MEDIA_TYPES)
								.and(RequestPredicates.accept(SUPPORTED_MEDIA_TYPES)), httpHandler::handleRequest);
				return builder.build();
		}

		private ServerResponse onlyAllowPost(ServerRequest request) {
				return ServerResponse.status(HttpStatus.METHOD_NOT_ALLOWED).headers(this::onlyAllowPost).build();
		}

		private void onlyAllowPost(HttpHeaders headers) {
				headers.setAllow(Collections.singleton(HttpMethod.POST));
		}
}
