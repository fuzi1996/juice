package juice.demo.config;

import juice.demo.support.SpringContextUtil;
import juice.finder.impl.StaticGraphqlDefinitionFinder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static juice.demo.constant.QueryConstant.QUERY_BOOK_BY_ID;
import static juice.demo.constant.QueryConstant.QUERY_USER_BY_ID;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

@SpringBootTest
class JuiceTestConfigurationTest {

		@Test
		public void testStaticGraphqlWrapperInject() {
				StaticGraphqlDefinitionFinder staticFinder = SpringContextUtil.getBean(StaticGraphqlDefinitionFinder.class);
				assertThat(staticFinder.getGraphQlDefinition(QUERY_BOOK_BY_ID), notNullValue());
		}

		@Test
		public void testStaticGraphqlBatchWrapperInject() {
				StaticGraphqlDefinitionFinder staticFinder = SpringContextUtil.getBean(StaticGraphqlDefinitionFinder.class);
				assertThat(staticFinder.getGraphQlDefinition(QUERY_USER_BY_ID), notNullValue());
		}


}