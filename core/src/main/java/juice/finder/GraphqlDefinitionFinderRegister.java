package juice.finder;

import juice.exception.JuiceServerWebInputException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.log.LogMessage;
import org.springframework.util.StringUtils;

import java.util.LinkedList;
import java.util.List;

public class GraphqlDefinitionFinderRegister {
		private static final Log logger = LogFactory.getLog(GraphqlDefinitionFinderRegister.class);

		private List<GraphqlDefinitionFinder> FINDER_LIST = new LinkedList<>();

		public void regist(GraphqlDefinitionFinder finder) {
				FINDER_LIST.add(finder);
		}

		public String getGraphQlDefinition(String key) {
				for (GraphqlDefinitionFinder finder : FINDER_LIST) {
						boolean match = finder.match(key);
						if (match) {
								String graphQlDefinition = finder.getGraphQlDefinition(key);
								if (StringUtils.hasText(graphQlDefinition)) {
										return graphQlDefinition;
								} else {
										logger.warn(LogMessage.format("GraphQl Finder [%s] match the key [%s], but get nothing", finder.getName(), key));
								}
						}
				}

				throw new JuiceServerWebInputException(String.format("No \"%s\" in the request document", key));
		}
}
