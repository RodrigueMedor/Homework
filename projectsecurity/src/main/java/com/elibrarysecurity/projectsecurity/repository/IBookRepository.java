package com.elibrarysecurity.projectsecurity.repository;


import com.elibrarysecurity.projectsecurity.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepository extends JpaRepository<Book,Long> {
}
