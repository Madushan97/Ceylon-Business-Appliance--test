package com.madushan.book.publishing.Entity;

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

    public Author(int authorId, String firstName, String lastName, String email, String contactNumber) {
        this.authorId = authorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.contactNumber = contactNumber;
    }

    public Author() {
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {

        if (!isFirstNameValid(firstName)) {
            throw new IllegalArgumentException("First Name should contains simple and capital letters only");
        }
        this.firstName = firstName;
    }

//    validation for the First Name
    private boolean isFirstNameValid(String firstName) {

        Pattern firstNamePattern = Pattern.compile("^[A-Za-z]+$");
        Matcher firstNameMatcher = firstNamePattern.matcher(firstName);
        return firstNameMatcher.matches();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {

        if(!isLastNameValid(lastName)) {
            throw new IllegalArgumentException("Last Name should contains simple and capital letters only");
        }
        this.lastName = lastName;
    }

//        validation for the Last Name
    private boolean isLastNameValid(String lastName) {

        Pattern lastNamePattern = Pattern.compile("^[A-Za-z]+$");
        Matcher lastNameMatcher = lastNamePattern.matcher(lastName);
        return lastNameMatcher.matches();
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

    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + authorId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                '}';
    }
}
