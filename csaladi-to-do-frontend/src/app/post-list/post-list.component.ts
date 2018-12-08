import { Component, Input } from '@angular/core';
import { Observable } from 'rxjs';

import { Task } from '../tasks.service';

@Component({
  selector: 'app-post-list',
  templateUrl: './post-list.component.html',
  styleUrls: ['./post-list.component.css']
})
export class TaskListComponent {

  @Input() private posts: Observable<Task[]>;
}
