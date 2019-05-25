package com.elibrarysecurity.projectsecurity.repository;


import com.elibrarysecurity.projectsecurity.model.CheckOutRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IChecKOutRecordRepository extends JpaRepository<CheckOutRecord,Long> {
}
