package com.madushan.book.publishing.Controller;

import com.madushan.book.publishing.DTO.AuthorDTO;
import com.madushan.book.publishing.DTO.BookDTO;
import com.madushan.book.publishing.Service.BookService;
import com.madushan.book.publishing.Util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/book")
@Validated
public class BookController {

    @Autowired
    private BookService bookService;

//        register Book
    @PostMapping(path = "/register")
    public ResponseEntity<StandardResponse> bookRegister(@Valid @RequestBody BookDTO bookDTO) {

        String message = bookService.bookRegistration(bookDTO);

        return new ResponseEntity<StandardResponse>(

                new StandardResponse(201, "Successfully Registered", message), HttpStatus.CREATED
        );
    }

    //    get registered authors
    @GetMapping(path = "/get-all-book")
    public ResponseEntity<StandardResponse> getAllBooks() {

        List<BookDTO> allBooks = bookService.getAllBooks();

        return new ResponseEntity<StandardResponse>(

                new StandardResponse(200, "Successfully", allBooks), HttpStatus.OK
        );
    }

//    get books by isbn
    @GetMapping( path = "/searchByISBN", params = {"isbn"})
    public ResponseEntity<StandardResponse> searchByISBN(@RequestParam(value = "isbn") String isbn) {

        BookDTO searchByISBN = bookService.searchByISBN(isbn);

        return new ResponseEntity<StandardResponse>(

                new StandardResponse(200, "Book found", searchByISBN), HttpStatus.OK
        );
    }

}
