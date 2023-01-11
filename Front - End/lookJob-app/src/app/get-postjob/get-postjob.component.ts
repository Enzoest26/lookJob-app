import { Component, OnInit } from '@angular/core';
import { JobPost } from '../models/job-post';
import { JobPostService } from '../models/job-post.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-get-postjob',
  templateUrl: './get-postjob.component.html',
  styleUrls: ['./get-postjob.component.css']
})
export class GetPostjobComponent implements OnInit{
  jobPost: JobPost | undefined;
  jobPostSimilars: JobPost[] | undefined;;
  
  ngOnInit(): void {
    this.route.paramMap.subscribe((params) => {
    let id = params.get('id');
    if (id && id !== '') {
      this.getJobPost(+id);
    }
  });
  }
  constructor(private jobService:JobPostService, private route: ActivatedRoute){
  }
  /*
  private setJobPost(data: JobPost){
    this.jobPost = data;
    console.log(this.jobPost);
    
  }

  private getJobPost(id: number){
    this.jobService.getOnlyPostJob(id).subscribe((data) => {
      this.setJobPost(data);
    });
    
  }*/
  //Using await method to wait for http request from the back-side server

  async getJobPost(id: number) {
    try {
      const data = await this.jobService.getOnlyPostJob(id).toPromise();
      this.jobPost = data;
      console.log(this.jobPost);
      console.log(this.jobPost?.requirements);
    } catch (error) {
      console.error(error);
    }

  }

  async onGetSimilarJobs(ids: Array<number>){
     try {
      console.log(ids);
      const data = await this.jobService.getSimilaritiesPostJobs(ids).toPromise();
      this.jobPostSimilars = data;
      console.log(this.jobPostSimilars);
    } catch (error) {
      console.error(error);
    }
  }
}
