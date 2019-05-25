package com.elibrarysecurity.projectsecurity.service;


import com.elibrarysecurity.projectsecurity.model.BookCopy;

import java.util.List;
import java.util.Optional;

public interface IBookCopyService {
    BookCopy add(BookCopy bookCopy);
    List<BookCopy> getAllBookCopies();
    Optional<BookCopy> findByBookCopyNumber(int bookCopyNumber);

}
