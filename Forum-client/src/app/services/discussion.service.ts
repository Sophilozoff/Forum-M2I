import {Injectable} from '@angular/core';
import {Discussion} from "../models/discussion.model";
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {Observable} from "rxjs";
import {Message} from "../models/message.model";

@Injectable({
  providedIn: 'root'
})
export class DiscussionService {

  constructor(private http: HttpClient) {
  }

  getDiscussion(id: number): Observable<Discussion> {
    return this.http.get<Discussion>(`${environment.apiUrl}/discussions/` + id);
  }

  getDiscussions(): Observable<Discussion[]> {
    return this.http.get<Discussion[]>(`${environment.apiUrl}/discussions`);
  }

  createDiscussion(discussion: Discussion) {
    return this.http.post<Discussion>(`${environment.apiUrl}/discussions/`, discussion);
  }

  getMessagesByDiscussionId(id: number): Observable<Message[]> {
    return this.http.get<Message[]>(`${environment.apiUrl}/messages/discussion-` + id);
  }

  createMessage(message: Message) {
    return this.http.post<Message>(`${environment.apiUrl}/messages/`, message);
  }

  likeDiscussion(id: number) {
    return this.http.put(`${environment.apiUrl}/discussions/like-` + id, {});
  }

  dislikeDiscussion(id: number) {
    return this.http.put(`${environment.apiUrl}/discussions/dislike-` + id, {});
  }
}
