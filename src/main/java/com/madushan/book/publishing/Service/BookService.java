package com.madushan.book.publishing.Service;

import com.madushan.book.publishing.DTO.BookDTO;

import java.util.List;

public interface BookService {

    String bookRegistration(BookDTO bookDTO);

    List<BookDTO> getAllBooks();

}
