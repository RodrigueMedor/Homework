package com.elibrarysecurity.projectsecurity.repository;


import com.elibrarysecurity.projectsecurity.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPositionRepository extends JpaRepository<Position,Integer> {
}
