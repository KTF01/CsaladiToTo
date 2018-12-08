import { Component, OnInit } from '@angular/core';
import { UserSessionService } from '../user-session.service';
import { UserService, User } from '../user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sign-in-page',
  templateUrl: './sign-in-page.component.html',
  styleUrls: ['./sign-in-page.component.css']
})
export class SignInPageComponent implements OnInit {

  private userCredentials: User;
  private errorMessage: string;

  constructor(private userSessionService: UserSessionService, private userService: UserService, private router: Router) {
    this.userCredentials = { username: '', password: '' };
  }

  ngOnInit() {
  }

  handleError(error: string) {
    if (error == 'WRONG_CREDENTIALS') {
      this.errorMessage = 'Wrong username-password pair!';
    }
  }

  handleSubmit(form) {
    if (form.valid) {
      const subscription = this.userService.signIn(this.userCredentials)
        .subscribe(user => {
          this.userSessionService.setCurrentUser(user);
          this.router.navigateByUrl('/home').then(() =>
            subscription.unsubscribe());
          }, e => this.handleError(e));
    }
  }
}
