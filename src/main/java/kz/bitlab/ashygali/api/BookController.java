package kz.bitlab.ashygali.api;

import kz.bitlab.ashygali.dto.BookDTO;
import kz.bitlab.ashygali.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/book")
public class BookController {

    private final BookService bookService;
    @GetMapping(value = "/get-book-list")
    public List<BookDTO> getBooks(){
        return bookService.getBooks();
    }

    @PostMapping(value = "/add-book")
    public BookDTO addBook(@RequestBody BookDTO book){

        return bookService.addBook(book);
    }
}
