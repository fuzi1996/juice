package juice.test.juice.finder;

import juice.finder.GraphqlDefinitionFinder;
import juice.test.juice.entity.Graphql;
import juice.test.juice.service.GraphqlService;

public class DynamicGraphqlDefinitionFinder implements GraphqlDefinitionFinder {

		private GraphqlService graphqlService;

		public DynamicGraphqlDefinitionFinder(GraphqlService graphqlService) {
				this.graphqlService = graphqlService;
		}

		@Override
		public boolean match(String s) {
				return s.startsWith("dynamic-");
		}

		@Override
		public String getGraphQlDefinition(String s) {
				Graphql graphql = this.graphqlService.getById(s);
				return graphql.getGraphql();
		}
}
