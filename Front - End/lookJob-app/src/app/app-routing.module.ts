import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListPostjobsComponent } from './list-postjobs/list-postjobs.component';
import { GetPostjobComponent } from './get-postjob/get-postjob.component';

const routes: Routes = [
  {path: 'posts', component: ListPostjobsComponent},
  {path: '', redirectTo:'posts', pathMatch:'full'},
  //For get the job
  {path: 'posts/get/:id', component: GetPostjobComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
