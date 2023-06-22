package com.madushan.book.publishing.Service.IMPL;

import com.madushan.book.publishing.DTO.AuthorDTO;
import com.madushan.book.publishing.Entity.Author;
import com.madushan.book.publishing.Repository.AuthorRepository;
import com.madushan.book.publishing.Service.AuthorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorServiceIMPL implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String authorRegistration(AuthorDTO authorDTO) {

        Author author = modelMapper.map(authorDTO, Author.class);

        authorRepository.save(author);

        return authorDTO.getFirstName() + " " + authorDTO.getLastName() + " registered.";
    }

    @Override
    public List<AuthorDTO> getAllAuthors() {

        List<Author> allAuthors = authorRepository.findAll();

        if (allAuthors.size() > 0) {

            List<AuthorDTO> authorList = new ArrayList<>();

            for (Author author : allAuthors) {

                AuthorDTO authorDTO = modelMapper.map(author, AuthorDTO.class);
                authorList.add(authorDTO);
            }

            return authorList;
        } else {

            throw new RuntimeException("No Authors in the DB");
        }

    }
}
