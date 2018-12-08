import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TasksService, Task } from '../tasks.service';
import { Observable } from 'rxjs';
import { mergeMap } from 'rxjs/operators';

@Component({
  selector: 'app-confirm-post-deletion-page',
  templateUrl: './confirm-post-deletion-page.component.html',
  styleUrls: ['./confirm-post-deletion-page.component.css']
})
export class ConfirmTasktDeletionPageComponent implements OnInit {

  private task: Observable<Task>;

  constructor(private activatedRoute: ActivatedRoute, private tasksService: TasksService, private router: Router) { }

  ngOnInit() {
    /*this.task = this.activatedRoute.paramMap
      .pipe(mergeMap(paramMap =>
        this.tasksService.findByPostNo(paramMap.get('postNo'))));*/
  }

  confirm(postNo) {
    /*const subscription = this.tasksService.deleteByPostNo(postNo)
      .subscribe(() =>
        this.router.navigateByUrl('/home').then(() =>
          subscription.unsubscribe()));*/
  }
}
