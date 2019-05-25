package com.elibrarysecurity.projectsecurity.mock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class MockRun {
    @Autowired
    private CreateData createData;
    @PostConstruct
    public void init(){
        createData.createMockData();
    }
}
