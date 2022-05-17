import { Component, OnInit } from '@angular/core';
import {DiscussionService} from "../../services/discussion.service";
import {ActivatedRoute} from "@angular/router";
import {Discussion} from "../../models/discussion.model";
import {Message} from "../../models/message.model";

@Component({
  selector: 'app-discussion',
  templateUrl: './discussion.component.html',
  styleUrls: ['./discussion.component.css']
})
export class DiscussionComponent implements OnInit {

  id: number;
  discussion!: Discussion;
  messages!: Message[];
  newDiscussion:boolean = false;

  constructor(private discussionService: DiscussionService, private route: ActivatedRoute) {
    this.id = this.route.snapshot.params['id'];
  }

  ngOnInit(): void {
    this.getDiscussion();
    this.getMessagesByDiscussionId(this.id);
  }

  getDiscussion() {
    return this.discussionService.getDiscussion(this.id)
      .subscribe(data => {
        this.discussion = data;
      });
  }

  getMessagesByDiscussionId(id: number){
    return this.discussionService.getMessagesByDiscussionId(id).subscribe( data => this.messages = data);
  }

  answerDiscussion() {
    this.newDiscussion = true;
  }

  cancelDiscussion() {
    this.newDiscussion = false;
  }
}
