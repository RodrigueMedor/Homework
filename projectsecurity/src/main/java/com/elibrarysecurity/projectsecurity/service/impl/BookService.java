package com.elibrarysecurity.projectsecurity.service.impl;


import com.elibrarysecurity.projectsecurity.model.Book;
import com.elibrarysecurity.projectsecurity.repository.IBookRepository;
import com.elibrarysecurity.projectsecurity.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {

    @Autowired
    public IBookRepository bookRepository;
    @Override
    public Book addBook(Book book) {

        return  bookRepository.save(book);
    }

    @Override
    public List<Book> getListOfBook() {
        return bookRepository.findAll(Sort.by("title"));
    }

    @Override
    public void removeBook(Long id)
    {
        bookRepository.deleteById(id);
    }

    @Override
    public Book findOneBook(Long id) {
        return bookRepository.findById(id).orElse(null);
    }
}
