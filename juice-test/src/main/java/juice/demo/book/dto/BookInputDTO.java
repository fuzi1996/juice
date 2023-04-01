package juice.demo.book.dto;

import juice.demo.book.entity.BookEntity;
import lombok.Data;

@Data
public class BookInputDTO extends BookEntity {
		private AuthorInputDTO author;
}
