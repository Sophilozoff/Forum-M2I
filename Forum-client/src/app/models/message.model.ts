import {Discussion} from "./discussion.model";

export class Message {

  id: number;
  content: string;
  author: string;
  discussion: Discussion;
  createdAt: Date;
  updatedAt: Date;
  likes: number;

  constructor(id: number, content: string, author: string, discussion: Discussion, createdAt: Date, updatedAt: Date, likes: number) {
    this.id = id;
    this.content = content;
    this.author = author;
    this.discussion = discussion;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.likes = likes;
  }
}
