package com.madushan.book.publishing.DTO;

import com.madushan.book.publishing.Entity.Author;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;

@Validated
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookDTO {

    private Long bookId;

    @Pattern(regexp = "^[a-zA-Z0-9]{13}$", message = "Title should contain only alphanumerics")
    private String ISBN;

    private ArrayList category;

    @Pattern(regexp = "^[a-zA-Z0-9]{13}$", message = "Title should contain only alphanumerics")
    private String title;

}
