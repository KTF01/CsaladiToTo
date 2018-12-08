import { Injectable } from '@angular/core';
import { Task } from './tasks.service';

export type Tag = {
  id: number,
  text: string,
  tasks: Task[]
};

@Injectable({
  providedIn: 'root'
})
export class TagService {

  constructor() { }
}
