import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { ApiService } from './api.service';
import { User } from './user.service';
import { Tag } from './tag.service';

export type Task = {
  id: number,
  taskName: string,
  text: string,
  userLead: User,
  worker: User[],
  comments: Comment[],
  tags: Tag[]
};

@Injectable({
  providedIn: 'root'
})
export class TasksService {

  constructor(private apiService: ApiService) { }

  findAll(): Observable<Task[]> {
    return this.apiService.findAll<Task[]>('/tasks/all');
  }

  //findTaskById(): Observable<Task>{
   // return this.apiService.findByNo<Task>('/tasks/get', id);
  //}

  findAllByPredicate(predicate): Observable<Task[]> {
    return this.findAll().pipe(map(x => x.filter(predicate)));
  }
/*
  findByPostNo(postNo): Observable<Task> {
    return this.apiService.findByNo<Task>('/tasks', postNo);
  }

  deleteByPostNo(postNo): Observable<void> {
    return this.apiService.deleteByNo('/tasks', postNo);
  }

  save(postNo, post): Observable<Task> {
    return this.apiService.putByNo('/tasks', postNo, post);
  }*/
}
