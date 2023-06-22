package com.madushan.book.publishing.Service;

import com.madushan.book.publishing.DTO.AuthorDTO;

import java.util.List;

public interface AuthorService {

    String authorRegistration(AuthorDTO authorDTO);

    List<AuthorDTO> getAllAuthors();
}
