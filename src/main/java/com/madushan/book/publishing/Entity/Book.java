package com.madushan.book.publishing.Entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity
@Table(name = "books")
@Validated
@TypeDefs({
        @TypeDef(name = "json", typeClass = JsonType.class)
})
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookId;

    @Column(name = "isbn", length = 13, nullable = false)
    private String ISBN;

    @Column(name = "category", length = 300)
    private ArrayList<String> category;

    @Column(name = "title", length = 100)
    private String title;

    public Book(Long bookId, String ISBN, ArrayList<String> category, String title) {
        this.bookId = bookId;
        this.ISBN = ISBN;
        this.category = category;
        this.title = title;
    }

    public Book() {

    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
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

    public ArrayList getCategory() {
        return category;
    }

    public void setCategory(ArrayList category) {
        this.category = category;
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

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", ISBN='" + ISBN + '\'' +
                ", category=" + category +
                ", title='" + title + '\'' +
                '}';
    }
}
