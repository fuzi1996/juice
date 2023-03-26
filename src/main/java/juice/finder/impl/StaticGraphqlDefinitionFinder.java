package juice.finder.impl;

import juice.finder.GraphqlDefinitionFinder;

import java.util.HashMap;
import java.util.Map;

public class StaticGraphqlDefinitionFinder implements GraphqlDefinitionFinder {

		private Map<String, String> GRAPHQL_CACHE = new HashMap<>();

		public void addGraphQL(String key, String definition) {
				GRAPHQL_CACHE.put(key, definition);
		}

		@Override
		public boolean match(String key) {
				return GRAPHQL_CACHE.containsKey(key);
		}

		@Override
		public String getGraphQlDefinition(String key) {
				return GRAPHQL_CACHE.get(key);
		}
}
