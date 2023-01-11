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
@CrossOrigin(origins = "http://localhost:4200")
public class JobPostController {
    @Autowired
    private final JobPostService jobPostService;

    public JobPostController(JobPostService jobPostService) {
        this.jobPostService = jobPostService;
    }

    @PostMapping("/add")
    public ResponseEntity<JobPost> addPostJob(@RequestBody JobPost jobPost ){
        JobPost postDisplay = jobPostService.postJob(jobPost);
        System.out.println("Works in add");
        return new ResponseEntity<>(postDisplay, HttpStatus.CREATED);
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<JobPost>> listAllPostJobs(){
        List<JobPost> listDisplay = jobPostService.listPostsJobs();
        System.out.println("Works in Get/All");
        return new ResponseEntity<>(listDisplay, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Optional<JobPost>> getPostJob(@PathVariable Long id){
        Optional<JobPost> jobDisplay = jobPostService.getOnlyJobPost(id);
        System.out.println("Works in Get/id");
        return new ResponseEntity<>(jobDisplay, HttpStatus.OK);
    }

    @PostMapping("/get/similarities")
    public ResponseEntity<List<Optional<JobPost>>> getPostSimilarities(@RequestBody Integer[] typesJobsype) {
        System.out.println("Types of jobs: " + typesJobsype);
        List<Optional<JobPost>> listPost= jobPostService.getSimilarJobs(typesJobsype);
        System.out.println("Works in similarities get/similars");
        return new ResponseEntity<>(listPost, HttpStatus.OK);
    }
}
