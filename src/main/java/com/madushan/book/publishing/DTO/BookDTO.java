package com.madushan.book.publishing.DTO;

import com.madushan.book.publishing.Entity.Author;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

@Validated
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookDTO {

    @Pattern(regexp = "^[a-zA-Z0-9]{13}$", message = "Title should contain only alphanumerics")
    private String ISBN;

    private List<String> category;

    @Pattern(regexp = "^[a-zA-Z0-9]{13}$", message = "Title should contain only alphanumerics")
    private String title;

    private Author author;

    private Integer likeCount;


}
