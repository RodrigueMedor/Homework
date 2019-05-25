package com.elibrarysecurity.projectsecurity.service;


import com.elibrarysecurity.projectsecurity.model.CheckinRecord;

import java.util.List;
import java.util.Optional;

public interface ICheckinRecordService {
    CheckinRecord addCheckinRecord(CheckinRecord checkinRecord);
    List<CheckinRecord> getCheckinRecords();
    Optional<CheckinRecord> findByCheckinRecordId(Long checkinRecordId);
    void delete(CheckinRecord checkinRecord);
}
