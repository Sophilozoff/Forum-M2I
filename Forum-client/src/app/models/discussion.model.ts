import {Message} from "./message.model";

export class Discussion {

  id: number;
  title: string;
  author: string;
  messages: Message[];
  firstMessage: Message;
  createdAt: Date;
  updatedAt: Date;
  likes: number;

  constructor(id: number, title: string, author: string, messages: Message[], firstMessage: Message, createdAt: Date, updatedAt: Date, likes: number) {
    this.id = id;
    this.title = title;
    this.author = author;
    this.messages = messages;
    this.firstMessage = firstMessage;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.likes = likes;
  }
}
