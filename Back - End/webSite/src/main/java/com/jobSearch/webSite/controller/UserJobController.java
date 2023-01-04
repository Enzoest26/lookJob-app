package com.jobSearch.webSite.controller;

import com.jobSearch.webSite.model.UserJob;
import com.jobSearch.webSite.service.UserJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserJobController {
    @Autowired
    private UserJobService userJobService;

    @PostMapping("/add")
    public ResponseEntity<UserJob> createUserJob(@RequestBody UserJob userJob){
        UserJob userDisplay = userJobService.createUserJob(userJob);
        return new ResponseEntity<>(userDisplay, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<UserJob> updateUserJob(@RequestBody UserJob userJob){
        UserJob userDisplay = userJobService.updateUserJob(userJob);
        return new ResponseEntity<>(userDisplay, HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<UserJob>> listUserJobs(){
        List<UserJob> list = userJobService.listUsersJobs();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
