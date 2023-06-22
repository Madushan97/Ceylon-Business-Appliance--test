package com.madushan.book.publishing.Service.IMPL;

import com.madushan.book.publishing.DTO.BookDTO;
import com.madushan.book.publishing.Entity.Book;
import com.madushan.book.publishing.Repository.BookRepository;
import com.madushan.book.publishing.Service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceIMPL implements BookService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public String bookRegistration(BookDTO bookDTO) {

        Book book = modelMapper.map(bookDTO, Book.class);
        bookRepository.save(book);

        return "Book ISBN : " + bookDTO.getISBN() + " added successfully";
    }

    @Override
    public List<BookDTO> getAllBooks() {

        List<Book> getAllBooks = bookRepository.findAll();

        if (getAllBooks.size() > 0) {

            List<BookDTO> allBooks = new ArrayList<>();

            for (Book book : getAllBooks) {

                BookDTO bookDTO = modelMapper.map(book, BookDTO.class);

                allBooks.add(bookDTO);
            }
            return allBooks;
        } else {

            throw new RuntimeException("No Books in DB");
        }
    }
}
