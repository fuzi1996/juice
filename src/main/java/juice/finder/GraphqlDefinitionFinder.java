package juice.finder;

public interface GraphqlDefinitionFinder {
		default String getName() {
				return this.getClass().getSimpleName();
		}

		boolean match(String key);

		String getGraphQlDefinition(String key);
}
