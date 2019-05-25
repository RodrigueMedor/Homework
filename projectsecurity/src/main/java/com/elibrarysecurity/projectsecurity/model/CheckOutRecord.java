package com.elibrarysecurity.projectsecurity.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "CHECKOUTRECORDS")
public class CheckOutRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long checkOutRecordId;
//    @NotNull(message = "* Date supplied is required")
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate checkOutDate = LocalDate.now();
//    @NotNull(message = "* Date supplied is required")
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate overdueDate = checkOutDate.plusDays(15);

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    @NotNull(message = "* User is required")
    private User user;

    @ManyToOne
    private BookCopy bookCopy;


    public CheckOutRecord() {
    }

    public CheckOutRecord(User user, BookCopy bookCopy) {
        this.user = user;
        this.bookCopy = bookCopy;
    }

    public Long getCheckOutRecordId() {
        return checkOutRecordId;
    }

    public void setCheckOutRecordId(Long checkOutRecordId) {
        this.checkOutRecordId = checkOutRecordId;
    }

    public LocalDate getOverdueDate() {
        return overdueDate;
    }

    public void setOverdueDate(LocalDate overdueDate) {
        this.overdueDate = overdueDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BookCopy getBookCopy() {
        return bookCopy;
    }

    public void setBookCopy(BookCopy bookCopy) {
        this.bookCopy = bookCopy;
    }
}
