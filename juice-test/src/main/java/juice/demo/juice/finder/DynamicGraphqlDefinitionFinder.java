package juice.demo.juice.finder;

import juice.demo.juice.entity.Graphql;
import juice.demo.juice.service.GraphqlService;
import juice.finder.GraphqlDefinitionFinder;

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
