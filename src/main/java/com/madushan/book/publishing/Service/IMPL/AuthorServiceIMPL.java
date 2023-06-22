package com.madushan.book.publishing.Service.IMPL;

import com.madushan.book.publishing.DTO.AuthorDTO;
import com.madushan.book.publishing.Entity.Author;
import com.madushan.book.publishing.Repository.AuthorRepository;
import com.madushan.book.publishing.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceIMPL implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public String autherRegistration(AuthorDTO authorDTO) {

        Author author = new Author(
                authorDTO.getAuthorId(),
                authorDTO.getFirstName(),
                authorDTO.getLastName(),
                authorDTO.getEmail(),
                authorDTO.getContactNumber()
        );

        authorRepository.save(author);

        return authorDTO.getFirstName() + " " + authorDTO.getLastName() + " registered.";
    }
}
