package com.madushan.book.publishing.Controller;

import com.madushan.book.publishing.DTO.AuthorDTO;
import com.madushan.book.publishing.Service.AuthorService;
import com.madushan.book.publishing.Util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping(path = "/register")
    public ResponseEntity<StandardResponse> authorRegister(@RequestBody AuthorDTO authorDTO) {

        String message = authorService.autherRegistration(authorDTO);

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Successfully Registered", message), HttpStatus.CREATED
        );
    }
}
