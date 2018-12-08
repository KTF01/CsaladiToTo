import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';

import { TasksService } from '../tasks.service';

@Component({
  selector: 'app-home-page',
  templateUrl: './feladatok-page.component.html',
  styleUrls: ['./feladatok-page.component.css']
})
export class HomePageComponent implements OnInit {

  private tasks: Observable<any>;

  constructor(private tasksService: TasksService) { }

  ngOnInit() {
    this.tasks = this.tasksService.findAll();
  }

}
