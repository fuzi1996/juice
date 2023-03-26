package juice.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "juice")
public class JuiceProperties {

		public JuiceProperties(){}

		private String path = "/juice";

		public String getPath() {
				return path;
		}

		public void setPath(String path) {
				this.path = path;
		}
}
