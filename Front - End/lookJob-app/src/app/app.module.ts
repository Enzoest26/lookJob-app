import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { ListPostjobsComponent } from './list-postjobs/list-postjobs.component';
import { CreatePostjobComponent } from './create-postjob/create-postjob.component';
import { GetPostjobComponent } from './get-postjob/get-postjob.component';

@NgModule({
  declarations: [
    AppComponent,

    ListPostjobsComponent,
    CreatePostjobComponent,
    GetPostjobComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
