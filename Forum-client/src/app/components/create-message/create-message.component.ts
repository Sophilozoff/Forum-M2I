import { Component, OnInit } from '@angular/core';
import {DiscussionService} from "../../services/discussion.service";
import {ActivatedRoute, Router} from "@angular/router";
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {first} from "rxjs";

@Component({
  selector: 'app-create-message',
  templateUrl: './create-message.component.html',
  styleUrls: ['./create-message.component.css']
})
export class CreateMessageComponent implements OnInit {

  discussionId!: number;
  messageForm: FormGroup;
  error: string = "";

  constructor(private fb: FormBuilder, private router: Router, private route: ActivatedRoute, private discussionService: DiscussionService) {
    this.discussionId = this.route.snapshot.params['id'];
    this.messageForm = this.fb.group({
      author: ["", [Validators.required]],
      content: ["", [Validators.required, Validators.minLength(6)]],
      discussion:  fb.group({id: this.discussionId}),
    })
  }

  ngOnInit(): void {
  }

  postNewMessage() {
    this.discussionService.createMessage(this.messageForm.value)
      .pipe(first()).subscribe({
      next: () => {
        this.router.navigate(['']);
      },
      error: (error: any) => {
        this.error = error.error.message;
      }
    });
  }
}
