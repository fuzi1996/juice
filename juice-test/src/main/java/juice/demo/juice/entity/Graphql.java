package juice.demo.juice.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Graphql {
		@TableId("`key`")
		private String key;
		private String graphql;
}
