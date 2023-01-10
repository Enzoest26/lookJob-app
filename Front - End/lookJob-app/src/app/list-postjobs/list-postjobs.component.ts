import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { JobPost } from '../models/job-post';
import { JobPostService } from '../models/job-post.service';

@Component({
  selector: 'app-list-postjobs',
  templateUrl: './list-postjobs.component.html',
  styleUrls: ['./list-postjobs.component.css']
})
export class ListPostjobsComponent implements OnInit {
  jobs: JobPost[] = [];

  constructor(private jobService: JobPostService, private router: Router){}
  ngOnInit(): void {
    //Called after the constructor, initializing input properties, and the first call to ngOnChanges.
    //Add 'implements OnInit' to the class.
    this.getAllJobsPost();
  }

  private getAllJobsPost(){
    this.jobService.getAllPostJobs().subscribe(data => this.jobs = data);
    console.log(this.jobs);
  }
  /*
  onPostClick(job: JobPost){
    this.router.navigate(['posts/get/'+job.id]);
    console.log(job);
  }
  */
  onPostClick(id: number){
    this.router.navigate(['posts/get/'+id]);
    
    //console.log(id);
  }

}
