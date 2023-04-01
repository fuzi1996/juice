package juice.demo.config;

import juice.demo.common.FileUtil;
import juice.demo.juice.finder.DynamicGraphqlDefinitionFinder;
import juice.demo.juice.service.GraphqlService;
import juice.finder.impl.StaticGraphqlDefinitionFinder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedList;

import static juice.demo.constant.QueryConstant.QUERY_BOOK_BY_ID;
import static juice.demo.constant.QueryConstant.QUERY_USER_BY_ID;

@Configuration
public class JuiceTestConfiguration {

		@Bean
		public StaticGraphqlDefinitionFinder.StaticGraphqlWrapper getQueryDefinition() {
				return new StaticGraphqlDefinitionFinder.StaticGraphqlWrapper(QUERY_BOOK_BY_ID, FileUtil.readGraphqlFile("bookById.graphqls"));
		}

		@Bean
		public StaticGraphqlDefinitionFinder.StaticGraphqlBatchWrapper getStaticGraphqlBatchWrapper() {
				StaticGraphqlDefinitionFinder.StaticGraphqlBatchWrapper batchWrapper = new StaticGraphqlDefinitionFinder.StaticGraphqlBatchWrapper();
				batchWrapper.setList(new LinkedList<StaticGraphqlDefinitionFinder.StaticGraphqlWrapper>() {
						{
								add(new StaticGraphqlDefinitionFinder.StaticGraphqlWrapper(QUERY_USER_BY_ID, FileUtil.readGraphqlFile("userById.graphqls")));
						}
				});
				return batchWrapper;
		}

		@Bean
		public DynamicGraphqlDefinitionFinder getDynamicGraphqlDefinitionFinder(GraphqlService graphqlService) {
				DynamicGraphqlDefinitionFinder finder = new DynamicGraphqlDefinitionFinder(graphqlService);
				return finder;
		}
}
