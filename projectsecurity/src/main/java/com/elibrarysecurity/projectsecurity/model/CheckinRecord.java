package com.elibrarysecurity.projectsecurity.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CHECKINRECORDS")
public class CheckinRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long checkingRecordId;


    @ManyToOne()
    @JoinColumn(name = "bookCopyId", nullable = false)
    @NotNull(message = "* BookCopy is required is required")
    private BookCopy bookCopy;

    private LocalDate checkInDate = LocalDate.now();


    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    @NotNull(message = "* User is required")
    private User user;

    public CheckinRecord(){}

    public CheckinRecord( BookCopy bookCopy, User user) {
        this.bookCopy = bookCopy;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getCheckingRecordId() {
        return checkingRecordId;
    }

    public void setCheckingRecordId(Long checkingRecordId) {
        this.checkingRecordId = checkingRecordId;
    }

    public BookCopy getBookCopy() {
        return bookCopy;
    }

    public void setBookCopy(BookCopy bookCopy) {
        this.bookCopy = bookCopy;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }
}
