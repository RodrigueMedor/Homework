package com.elibrarysecurity.projectsecurity.service;



import com.elibrarysecurity.projectsecurity.model.CheckOutRecord;

import java.util.List;
import java.util.Optional;

public interface ICheckOutRecordService {
    CheckOutRecord addCheckOutRecord(CheckOutRecord checkOutRecord);
    List<CheckOutRecord> getCheckOutRecords();
    Optional<CheckOutRecord> findByCheckOutRecordId(Long checkOutRecordId);
    void delete(CheckOutRecord checkOutRecord);
}
