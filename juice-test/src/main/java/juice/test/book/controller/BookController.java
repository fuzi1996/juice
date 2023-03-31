package juice.test.book.controller;

import juice.test.book.dto.BookInputDTO;
import juice.test.book.entity.AuthorEntity;
import juice.test.book.entity.BookEntity;
import juice.test.book.service.IAuthorService;
import juice.test.book.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {
		@Autowired
		private IBookService bookService;
		@Autowired
		private IAuthorService authorService;

		@QueryMapping
		public BookEntity bookById(@Argument String id) {
				return this.bookService.getById(id);
		}

		@MutationMapping
		public BookEntity deleteBook(@Argument String id) {
				BookEntity bookEntity = this.bookService.getById(id);
				return bookEntity;
		}

		@MutationMapping("createBook")
		public BookInputDTO saveBook(@Argument BookInputDTO book) {
				return book;
		}

		@SchemaMapping(field = "author", typeName = "Book")
		public AuthorEntity getAuthorByBook(BookEntity bookEntity) {
				return this.authorService.getById(bookEntity.getAuthorId());
		}
}