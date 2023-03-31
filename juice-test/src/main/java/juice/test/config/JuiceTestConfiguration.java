package juice.test.config;

import juice.finder.impl.StaticGraphqlDefinitionFinder;
import juice.test.common.FileUtil;
import juice.test.juice.finder.DynamicGraphqlDefinitionFinder;
import juice.test.juice.service.GraphqlService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JuiceTestConfiguration {
//		@Bean
//		public StaticGraphqlDefinitionFinder getStaticGraphqlDefinitionFinder(){
//				StaticGraphqlDefinitionFinder finder = new StaticGraphqlDefinitionFinder();
//				finder.addGraphQL("query","query ($id: ID){\nbookById(id: $id){\nid\nname\npageCount\nauthor {\nfirstName\nlastName}\n}\n}");
//				finder.addGraphQL("delete","mutation ($id:ID!){deleteBook(id: $id){id\nname\npageCount\nauthor {\nfirstName\nlastName\n}\n}\n}");
//				finder.addGraphQL("save","mutation ($book:BookInput!){\ncreateBook(\nbook: $book){\nid\n}\n}");
//				return finder;
//		}

		@Bean
		public StaticGraphqlDefinitionFinder.StaticGraphqlWrapper getQueryDefinition() {
				return new StaticGraphqlDefinitionFinder.StaticGraphqlWrapper("query", FileUtil.readGraphqlFile("query.graphqls"));
		}

		@Bean
		public DynamicGraphqlDefinitionFinder getDynamicGraphqlDefinitionFinder(GraphqlService graphqlService) {
				DynamicGraphqlDefinitionFinder finder = new DynamicGraphqlDefinitionFinder(graphqlService);
				return finder;
		}
}
