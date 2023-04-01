package juice.demo.common;

import cn.hutool.core.io.resource.NoResourceException;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
public class FileUtil {
		public static String readGraphqlFile(String path) {
				InputStream inputStream = FileUtil.class.getResourceAsStream(String.format("/graphql-define/%s", path));
				if (Objects.nonNull(inputStream)) {
						return new BufferedReader(
										new InputStreamReader(inputStream, StandardCharsets.UTF_8))
										.lines()
										.collect(Collectors.joining("\n"));
				} else {
						throw new NoResourceException(String.format("文件[%s]不存在", path));
				}

		}
}
