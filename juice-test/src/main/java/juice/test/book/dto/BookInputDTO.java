package juice.test.book.dto;

import juice.test.book.entity.BookEntity;
import lombok.Data;

@Data
public class BookInputDTO extends BookEntity {
		private AuthorInputDTO author;
}
