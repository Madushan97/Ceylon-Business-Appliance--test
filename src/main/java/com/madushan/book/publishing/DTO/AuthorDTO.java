package com.madushan.book.publishing.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthorDTO {

    private int authorId;
    private String firstName;
    private String lastName;
    private String email;
    private String contactNumber;
}
