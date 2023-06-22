package com.madushan.book.publishing.Controller;

import com.madushan.book.publishing.DTO.AuthorDTO;
import com.madushan.book.publishing.Service.AuthorService;
import com.madushan.book.publishing.Util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/author")
@Validated
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping(path = "/register")
    public ResponseEntity<StandardResponse> authorRegister(@Valid @RequestBody AuthorDTO authorDTO) {

        String message = authorService.authorRegistration(authorDTO);

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Successfully Registered", message), HttpStatus.CREATED
        );
    }

    @GetMapping(path = "/get-all-author")
    public ResponseEntity<StandardResponse> getAllAuthors() {

        List<AuthorDTO> allAuthors = authorService.getAllAuthors();

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Successfully", allAuthors), HttpStatus.OK
        );
    }

}
