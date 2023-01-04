package com.jobSearch.webSite.service;

import com.jobSearch.webSite.model.UserJob;
import com.jobSearch.webSite.repository.UserJobRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserJobService {
    @Autowired
    private UserJobRepository userJobRepository;

    public UserJob createUserJob(UserJob userJob){
        return userJobRepository.save(userJob);
    }

    public UserJob updateUserJob(UserJob userJob){
        return userJobRepository.save(userJob);
    }

    public List<UserJob> listUsersJobs(){
        return userJobRepository.findAll();
    }
}
