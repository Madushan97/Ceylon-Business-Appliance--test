package com.madushan.book.publishing.DTO;

import com.madushan.book.publishing.Entity.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Pattern;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Validated
public class AuthorDTO {

    private int authorId;

    @Pattern(regexp = "^[A-Za-z]+$", message = "First Name should contain only simple and capital letters")
    private String firstName;

    @Pattern(regexp = "^[A-Za-z]+$", message = "First Name should contain only simple and capital letters")
    private String lastName;

    private String email;

    private String contactNumber;

}
