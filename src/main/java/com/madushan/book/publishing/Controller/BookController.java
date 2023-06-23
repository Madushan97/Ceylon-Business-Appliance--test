package com.madushan.book.publishing.Controller;

import com.madushan.book.publishing.DTO.AuthorDTO;
import com.madushan.book.publishing.DTO.BookDTO;
import com.madushan.book.publishing.Service.BookService;
import com.madushan.book.publishing.Util.StandardResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookService bookService;

//        register Book
    @PostMapping(path = "/register")
    public ResponseEntity<StandardResponse> bookRegister(@Valid @RequestBody BookDTO bookDTO) {

//        check whether author is there
        if (bookDTO.getAuthor() == null) {

            logger.warn("Author is required for book registration");

            return new ResponseEntity<StandardResponse>(
                    new StandardResponse(400, "Author is required for book registration", null),
                    HttpStatus.BAD_REQUEST
            );
        }

        String message = bookService.bookRegistration(bookDTO);

        logger.info("Book registered successfully");

        return new ResponseEntity<StandardResponse>(

                new StandardResponse(201, "Successfully Registered", message),
                HttpStatus.CREATED
        );
    }

    //    get registered authors
    @GetMapping(path = "/get-all-book")
    public ResponseEntity<StandardResponse> getAllBooks() {

        List<BookDTO> allBooks = bookService.getAllBooks();

        logger.info("Retrieved all books");

        return new ResponseEntity<StandardResponse>(

                new StandardResponse(200, "Successfully", allBooks),
                HttpStatus.OK
        );
    }

//    get books by isbn
    @GetMapping( path = "/searchByISBN", params = {"isbn"})
    public ResponseEntity<StandardResponse> searchByISBN(@RequestParam(value = "isbn") String isbn) {

        BookDTO searchByISBN = bookService.searchByISBN(isbn);

        logger.info("Book found by ISBN");

        return new ResponseEntity<StandardResponse>(

                new StandardResponse(200, "Book found", searchByISBN),
                HttpStatus.OK
        );
    }

//    Like feature
    @PostMapping(path = "/like/{isbn}")
    public ResponseEntity<StandardResponse> likeBook(@PathVariable(value = "isbn") String isbn) {

        String message = bookService.likeBook(isbn);

        logger.info("Book Liked Successfully");

        return new ResponseEntity<StandardResponse>(

                new StandardResponse(200, "Book found", message),
                HttpStatus.OK
        );
    }
}
