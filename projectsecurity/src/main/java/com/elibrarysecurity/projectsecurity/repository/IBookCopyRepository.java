package com.elibrarysecurity.projectsecurity.repository;


import com.elibrarysecurity.projectsecurity.model.BookCopy;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IBookCopyRepository extends JpaRepository<BookCopy,Integer> {
}
