package com.elibrarysecurity.projectsecurity.repository;


import com.elibrarysecurity.projectsecurity.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository  extends JpaRepository<Category,Integer> {
}
