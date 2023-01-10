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
  private setJobPost(data: JobPost){
    this.jobPost = data;
    console.log(this.jobPost);
  }
  /*
  private getJobPost(id: number){
    this.jobService.getOnlyPostJob(id).subscribe((data) => {
      this.setJobPost(data);
    });
    
  }*/
  private async getJobPost(id: number) {
    try {
      const data = await this.jobService.getOnlyPostJob(id).toPromise();
      this.jobPost = data;
      console.log(this.jobPost);
    } catch (error) {
      console.error(error);
    }
}

}
