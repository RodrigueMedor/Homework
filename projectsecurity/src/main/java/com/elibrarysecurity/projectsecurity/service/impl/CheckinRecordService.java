package com.elibrarysecurity.projectsecurity.service.impl;



import com.elibrarysecurity.projectsecurity.model.CheckinRecord;
import com.elibrarysecurity.projectsecurity.repository.ICheckinRecordRepository;
import com.elibrarysecurity.projectsecurity.service.ICheckinRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CheckinRecordService implements ICheckinRecordService {
    @Autowired
    public ICheckinRecordRepository checkinRecordRepository;

    @Override
    public CheckinRecord addCheckinRecord(CheckinRecord checkinRecord) {
        return checkinRecordRepository.save(checkinRecord);
    }

    @Override
    public List<CheckinRecord> getCheckinRecords() {
        return checkinRecordRepository.findAll();
    }

    @Override
    public Optional<CheckinRecord> findByCheckinRecordId(Long checkinRecordId) {
        return checkinRecordRepository.findById(checkinRecordId);
    }

    @Override
    public void delete(CheckinRecord checkinRecord) {
        checkinRecordRepository.delete(checkinRecord);
    }
}
