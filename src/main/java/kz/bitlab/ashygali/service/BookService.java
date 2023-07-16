package kz.bitlab.ashygali.service;

import kz.bitlab.ashygali.dto.BookDTO;
import kz.bitlab.ashygali.mapper.BookMapper;
import kz.bitlab.ashygali.model.Books;
import kz.bitlab.ashygali.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    public List<BookDTO> getBooks(){
        return bookMapper.toDtoList(bookRepository.findAll());
    }

    public BookDTO addBook(BookDTO book){
        return bookMapper.toDto(bookRepository.save(bookMapper.toModel(book)));
    }

    public BookDTO getBooks(Long id){
        return bookMapper.toDto(bookRepository.findById(id).orElse(new Books()));
    }

    public BookDTO updateBooks(BookDTO book){
        return bookMapper.toDto(bookRepository.save(bookMapper.toModel(book)));
    }
    public void deleteBooks(Long id){
        bookRepository.deleteById(id);
    }

}

