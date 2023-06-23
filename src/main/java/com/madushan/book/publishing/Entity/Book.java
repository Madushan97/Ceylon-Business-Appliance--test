package com.madushan.book.publishing.Entity;

import com.madushan.book.publishing.DTO.AuthorDTO;
import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "books")
@Validated
@TypeDefs({
        @TypeDef(name = "json", typeClass = JsonType.class)
})
public class Book {

    @Id
    @Column(name = "isbn", length = 13, nullable = false)
    private String ISBN;

    @ElementCollection
    @Column(name = "category", length = 300)
    @CollectionTable(name = "book_category", joinColumns = @JoinColumn(name = "isbn"))
    private List<String> category;

    @Column(name = "title", length = 100)
    private String title;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    @Column(name = "like_count", length = 100)
    private int likeCount;

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {

        if(!isISBNValid(ISBN)) {

            throw new IllegalArgumentException("ISBN should only contains alphanumeric");
        }
        this.ISBN = ISBN;
    }

    private boolean isISBNValid(String ISBN) {

//        remove hyphens or spaces
        ISBN = ISBN.replaceAll("[\\s-]", "");

        Pattern ISBNPattern = Pattern.compile("^[a-zA-Z0-9]+$");
        Matcher ISBNMatcher = ISBNPattern.matcher(ISBN);
        return ISBNMatcher.matches();
    }

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {

        if (!isTitleValid(title)) {
            throw new IllegalArgumentException("Title Should contains only alphanumeric");
        }
        this.title = title;
    }

    private boolean isTitleValid(String title) {

        Pattern titlePattern = Pattern.compile("^[a-zA-Z0-9]+$");
        Matcher ISBNMatcher = titlePattern.matcher(title);
        return ISBNMatcher.matches();
    }


}
