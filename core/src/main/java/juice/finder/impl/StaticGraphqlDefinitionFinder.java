package juice.finder.impl;

import juice.finder.GraphqlDefinitionFinder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StaticGraphqlDefinitionFinder implements GraphqlDefinitionFinder {

		private Map<String, String> GRAPHQL_CACHE = new HashMap<>();

		public void addGraphQL(StaticGraphqlWrapper wrapper) {
				GRAPHQL_CACHE.put(wrapper.getKey(), wrapper.getDefinition());
		}

		@Override
		public boolean match(String key) {
				return GRAPHQL_CACHE.containsKey(key);
		}

		@Override
		public String getGraphQlDefinition(String key) {
				return GRAPHQL_CACHE.get(key);
		}

		public static class StaticGraphqlWrapper {
				private String key;
				private String definition;

				public StaticGraphqlWrapper() {
				}

				public StaticGraphqlWrapper(String key, String definition) {
						this.key = key;
						this.definition = definition;
				}

				public String getKey() {
						return key;
				}

				public void setKey(String key) {
						this.key = key;
				}

				public String getDefinition() {
						return definition;
				}

				public void setDefinition(String definition) {
						this.definition = definition;
				}
		}

		public static class StaticGraphqlBatchWrapper {
				private List<StaticGraphqlWrapper> list;

				public StaticGraphqlBatchWrapper() {
				}

				public StaticGraphqlBatchWrapper(List<StaticGraphqlWrapper> list) {
						this.list = list;
				}

				public List<StaticGraphqlWrapper> getList() {
						return list;
				}

				public void setList(List<StaticGraphqlWrapper> list) {
						this.list = list;
				}
		}
}