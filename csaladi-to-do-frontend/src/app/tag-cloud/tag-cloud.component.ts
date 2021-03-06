import { Component, OnInit } from '@angular/core';
import { TasksService } from '../tasks.service';
import { map, concatMap, reduce } from 'rxjs/operators';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-tag-cloud',
  templateUrl: './tag-cloud.component.html',
  styleUrls: ['./tag-cloud.component.css']
})
export class TagCloudComponent implements OnInit {
  
  private tags: Observable<Set<string>>;

  constructor(private tasksService: TasksService) { }

  ngOnInit() {
    this.tags = this.tasksService.findAll()
      .pipe(map(posts =>
        posts.reduce((tags, post) =>
          post.tags.reduce((tags, tag) =>
            tags.add(tag), tags), new Set())));
  }
}
