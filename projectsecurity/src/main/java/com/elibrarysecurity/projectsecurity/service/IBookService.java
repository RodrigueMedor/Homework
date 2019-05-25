package com.elibrarysecurity.projectsecurity.service;



import com.elibrarysecurity.projectsecurity.model.Book;

import java.util.List;

public interface IBookService {
     Book addBook(Book book);
     List<Book> getListOfBook();
     void removeBook(Long id);
     Book findOneBook(Long id);


}
