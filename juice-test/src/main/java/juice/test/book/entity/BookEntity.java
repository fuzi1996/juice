package juice.test.book.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("book")
public class BookEntity {

		private String id;
		private String name;
		private int pageCount;
		private String authorId;
}