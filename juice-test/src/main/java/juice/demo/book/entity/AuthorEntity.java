package juice.demo.book.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("author")
public class AuthorEntity {
		private String id;
		private String firstName;
		private String lastName;
}