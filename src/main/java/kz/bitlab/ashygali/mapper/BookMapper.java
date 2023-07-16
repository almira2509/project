package kz.bitlab.ashygali.mapper;

import kz.bitlab.ashygali.dto.BookDTO;
import kz.bitlab.ashygali.model.Books;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookDTO toDto(Books books);
    Books toModel(BookDTO bookDTO);
    List<BookDTO> toDtoList(List<Books> booksList);
    List<Books> toModelList(List<BookDTO> bookDTOList);
}
