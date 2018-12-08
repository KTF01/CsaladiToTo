import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { TasksService, Task } from '../tasks.service';
import { Observable } from 'rxjs';
import { mergeMap } from 'rxjs/operators';

@Component({
  selector: 'app-post-list-by-tag',
  templateUrl: './post-list-by-tag.component.html',
  styleUrls: ['./post-list-by-tag.component.css']
})
export class PostListByTagComponent implements OnInit {

  private posts: Observable<Task[]>;

  constructor(private activatedRoute: ActivatedRoute, private tasksService: TasksService) { }

  ngOnInit() {
    this.posts = this.activatedRoute.paramMap
      .pipe(mergeMap(paramMap =>
        this.tasksService.findAllByPredicate(function (post) {
          return post.tags.some(tag => tag.text === paramMap.get('tag'));
        })));
  }
}
