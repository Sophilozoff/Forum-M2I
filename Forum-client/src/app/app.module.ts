import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import { NavbarComponent } from './components/shared/navbar/navbar.component';
import { CreateDiscussionComponent } from './components/create-discussion/create-discussion.component';
import { DiscussionsComponent } from './components/discussions/discussions.component';
import { DiscussionComponent } from './components/discussion/discussion.component';
import { CreateMessageComponent } from './components/create-message/create-message.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NavbarComponent,
    CreateDiscussionComponent,
    DiscussionsComponent,
    DiscussionComponent,
    CreateMessageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
