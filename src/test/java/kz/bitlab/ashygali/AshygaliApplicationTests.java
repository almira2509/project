package kz.bitlab.ashygali;

import kz.bitlab.ashygali.dto.BookDTO;
import kz.bitlab.ashygali.mapper.BookMapper;
import kz.bitlab.ashygali.model.Books;
import kz.bitlab.ashygali.repository.BookRepository;
import kz.bitlab.ashygali.service.BookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
class TestApp {

@Autowired
private BookMapper bookMapper;

@Autowired
private BookService bookService;

@Autowired
private BookRepository bookRepository;

@Test
	void contextLoads() {
	void checkBookDto() {

		Books book = new Books();
		book.setId(1234L);
		book.setName("New book");
		book.setDescription("Another good book");
		book.setAuthor("Brilliant Author");

		BookDTO bookDTO = bookMapper.toDto(book);

		Assertions.assertEquals(book.getName(), bookDTO.getName());
		Assertions.assertEquals(book.getId(), bookDTO.getId());
		Assertions.assertEquals(book.getDescription(), bookDTO.getDescription());
		Assertions.assertEquals(book.getAuthor(), bookDTO.getAuthor());

	}
}

@Test
	void checkInsertIntoDb(){

			bookRepository.deleteAll();

			String bookName = "Some book";
			String bookDescription = "Yet another book";
			String bookAuthor = "One of the best authors ever";

			Books book = new Books();
			book.setName(bookName);
			book.setDescription(bookDescription);
			book.setAuthor(bookAuthor);

			BookDTO newBook = bookService.addBook(bookMapper.toDto(book));

			Assertions.assertNotNull(newBook);
			Assertions.assertNotNull(newBook.getId());
			Assertions.assertEquals(bookName, newBook.getName());
			Assertions.assertEquals(bookAuthor, newBook.getAuthor());
			Assertions.assertEquals(bookDescription, newBook.getDescription());

			bookRepository.deleteAll();

			}
}
