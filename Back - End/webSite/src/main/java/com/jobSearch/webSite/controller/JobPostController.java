package com.jobSearch.webSite.controller;

import com.jobSearch.webSite.model.JobPost;
import com.jobSearch.webSite.service.JobPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/post")
public class JobPostController {
    @Autowired
    private JobPostService jobPostService;

    @PostMapping("/add")
    public ResponseEntity<JobPost> addPostJob(@RequestBody JobPost jobPost ){
        JobPost postDisplay = jobPostService.postJob(jobPost);
        return new ResponseEntity<>(postDisplay, HttpStatus.CREATED);
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<JobPost>> listAllPostJobs(){
        List<JobPost> listDisplay = jobPostService.listPostsJobs();
        return new ResponseEntity<>(listDisplay, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Optional<JobPost>> getPostJob(@PathVariable Long id){
        Optional<JobPost> jobDisplay = jobPostService.getOnlyJobPost(id);
        return new ResponseEntity<>(jobDisplay, HttpStatus.OK);
    }
}
