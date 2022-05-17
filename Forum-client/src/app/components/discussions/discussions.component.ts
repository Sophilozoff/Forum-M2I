import { Component, OnInit } from '@angular/core';
import {DiscussionService} from "../../services/discussion.service";
import {Discussion} from "../../models/discussion.model";

@Component({
  selector: 'app-discussions',
  templateUrl: './discussions.component.html',
  styleUrls: ['./discussions.component.css']
})
export class DiscussionsComponent implements OnInit {

  discussions!: Discussion[];

  constructor(private discussionService: DiscussionService) { }

  ngOnInit(): void {
    this.getDiscussions();
  }

  getDiscussions() {
    return this.discussionService.getDiscussions()
      .subscribe(data => this.discussions = data);
  }

  like(id: number) {
    this.discussionService.likeDiscussion(id).subscribe();
  }

  dislike(id: number) {
    this.discussionService.likeDiscussion(id).subscribe();
  }

}
