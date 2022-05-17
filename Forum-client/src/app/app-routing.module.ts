import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {HomeComponent} from "./components/home/home.component";
import {CreateDiscussionComponent} from "./components/create-discussion/create-discussion.component";
import {DiscussionsComponent} from "./components/discussions/discussions.component";
import {DiscussionComponent} from "./components/discussion/discussion.component";

const routes: Routes = [
  {
    path: "", component: HomeComponent
  },
  {
    path: "nouvelle-discussion", component: CreateDiscussionComponent
  },
  {
    path: "discussions", component: DiscussionsComponent
  },
  {
    path: "discussion/:id",
    component: DiscussionComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
