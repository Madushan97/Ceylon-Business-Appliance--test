package com.madushan.book.publishing.Entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity
@Table(name = "author")
@Validated
public class Author {

    @Id
    @Column(name = "author_id", length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int authorId;

    @Column(name = "first_name", length = 100, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 100, nullable = false)
    private String lastName;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "contact_number", length = 45, nullable = false)
    private String contactNumber;

    @OneToMany(mappedBy = "author")
    private List<Book> books;

    @Column(name = "like_count", length = 100)
    private int likeCount;

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public String getFirstName() {
        return firstName;
    }

//    first name validation and set it
    public void setFirstName(String firstName) {

        if (!isFirstNameValid(firstName)) {
            throw new IllegalArgumentException("First Name should contains simple and capital letters only");
        }
        this.firstName = firstName;
    }

    private boolean isFirstNameValid(String firstName) {

        Pattern firstNamePattern = Pattern.compile("^[A-Za-z]+$");
        Matcher firstNameMatcher = firstNamePattern.matcher(firstName);
        return firstNameMatcher.matches();
    }

    public String getLastName() {
        return lastName;
    }

//    lastName validation and set it
    public void setLastName(String lastName) {

        if(!isLastNameValid(lastName)) {
            throw new IllegalArgumentException("Last Name should contains simple and capital letters only");
        }
        this.lastName = lastName;
    }

    private boolean isLastNameValid(String lastName) {

        Pattern lastNamePattern = Pattern.compile("^[A-Za-z]+$");
        Matcher lastNameMatcher = lastNamePattern.matcher(lastName);
        return lastNameMatcher.matches();
    }
 }

