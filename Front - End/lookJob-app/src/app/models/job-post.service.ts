import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { JobPost } from './job-post';

@Injectable({
  providedIn: 'root'
})
export class JobPostService {
private baseURL = 'http://localhost:8080/post';
  constructor(private httpClient: HttpClient, private router: ActivatedRoute) { 

  }
  //Base of URL
  //Return in a list all the post of jobs
  getAllPostJobs() : Observable<JobPost[]> {
    return this.httpClient.get<JobPost[]>(`${this.baseURL}/get/all`);
  }
  getOnlyPostJob(id: number): Observable<JobPost>{
    return this.httpClient.get<JobPost>(`${this.baseURL}/get/${id}`);
  }
  
}
