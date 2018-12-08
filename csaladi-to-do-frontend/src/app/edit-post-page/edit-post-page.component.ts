import { Component, OnInit } from '@angular/core';
import { TasksService} from '../tasks.service';
import { Tag } from '../tag.service';
import { ActivatedRoute, Router } from '@angular/router';
import { mergeMap } from 'rxjs/operators';
import { Subscription } from 'rxjs';
import { User } from '../user.service';
type Task = {
  taskName: string,
  userLead: User,
  worker: User[],
  comments: Comment[],
  tags: Tag[]
};

@Component({
  selector: 'app-edit-post-page',
  templateUrl: './edit-post-page.component.html',
  styleUrls: ['./edit-post-page.component.css']
})
export class EditPostPageComponent implements OnInit {

  private task: Task;
  private subscription: Subscription;

  constructor(private activatedRoute: ActivatedRoute, private tasksService: TasksService, private router: Router) {
    this.task = {
      taskName: '',
      userLead: null,
      worker: [],
      comments: [],
      tags: []
    };
  }

  ngOnInit() {
    /*this.subscription = this.activatedRoute.paramMap
      .pipe(mergeMap(paramMap =>
        this.tasksService.findByPostNo(paramMap.get('postNo'))))
      .subscribe(post => {
        this.post = {
          title: post.title,
          text: post.text,
          tags: post.tags.map(tag => tag.text).join(', ')
        };
      })*/
  }

  handleSubmit(form) {
    /*if (form.valid) {
      this.subscription.unsubscribe();

      this.activatedRoute.paramMap.subscribe(paramMap => {
        const post = {
          title: this.post.title,
          text: this.post.text,
          tags: this.post.tags.split(', ').map(tag => ({ text: tag }))
        };
        
        const subscription = this.postsService.save(paramMap.get('postNo'), post)
          .subscribe(() =>
            this.router.navigateByUrl('/home').then(() =>
              subscription.unsubscribe()));
      });
    }*/
  }
}
