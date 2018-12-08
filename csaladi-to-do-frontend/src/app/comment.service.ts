import { Injectable } from '@angular/core';
import { Task } from './tasks.service';

export type Comment = {
  id: number,
  author: string,
  text: string,
  task: Task
};


@Injectable({
  providedIn: 'root'
})
export class CommentService {

  constructor() { }
}
