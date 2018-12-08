import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { Task, TasksService } from '../tasks.service';
import { mergeMap } from 'rxjs/operators';

@Component({
  selector: 'app-search-results-page',
  templateUrl: './search-results-page.component.html',
  styleUrls: ['./search-results-page.component.css']
})
export class SearchResultsPageComponent implements OnInit {

  private tasks: Observable<Task[]>;

  constructor(private activatedRoute: ActivatedRoute, private tasksService: TasksService) { }

  ngOnInit() {
    this.tasks = this.activatedRoute.paramMap
      .pipe(mergeMap(paramMap =>
        this.tasksService.findAllByPredicate(function (task) {
          const keywords = paramMap.get('keywords').split(/\s/g);
          
          return keywords.some(keyword => task.title.includes(keyword) || task.text.includes(keyword));
        })));
  }

}
