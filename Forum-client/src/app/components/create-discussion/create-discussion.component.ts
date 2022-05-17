import { Component, OnInit } from '@angular/core';
import {first} from "rxjs";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {DiscussionService} from "../../services/discussion.service";

@Component({
  selector: 'app-create-discussion',
  templateUrl: './create-discussion.component.html',
  styleUrls: ['./create-discussion.component.css']
})
export class CreateDiscussionComponent implements OnInit {

  discussionForm: FormGroup;
  error: string = "";

  constructor(private fb: FormBuilder, private router: Router,
              private discussionService: DiscussionService) {
    this.discussionForm = this.fb.group({
        title: ["", [Validators.required, Validators.minLength(3)]],
        author: ["", [Validators.required]],
        firstMessage: ["", [Validators.required, Validators.minLength(6)]]
      },
      {});
  }

  ngOnInit(): void {
  }

  postNewDiscussion() {
    this.discussionService.createDiscussion(this.discussionForm.value)
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
