package kz.bitlab.ashygali.api;

import kz.bitlab.ashygali.dto.BookDTO;
import kz.bitlab.ashygali.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/book")
@RequiredArgsConstructor
public class BookRestController {

    private final BookService bookService;
    @GetMapping
    public List<BookDTO> booksList(){
        return bookService.getBooks();
    }

    @GetMapping(value = "{id}")
    public BookDTO getBooks(@PathVariable(name = "id") Long id){
        return bookService.getBooks(id);
    }

    @PostMapping
    public BookDTO addBook(@RequestBody BookDTO book){
        return bookService.addBook(book);
    }

    @PutMapping
    public BookDTO updateBooks(@RequestBody BookDTO book){
        return bookService.updateBooks(book);
    }

    @DeleteMapping(value = "{id}")
    public void deleteBooks(@PathVariable(name = "id") Long id){
        bookService.deleteBooks(id);
    }
}
