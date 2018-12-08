import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { User } from './user.service';

@Injectable({
  providedIn: 'root'
})
export class UserSessionService {

  private currentUser: BehaviorSubject<User>;

  constructor() {
    this.currentUser = new BehaviorSubject(null);
  }

  setCurrentUser(user: User) {
    this.currentUser.next(user);
  }

  signOut() {
    this.setCurrentUser(null);
  }

  getCurrentUser() {
    return this.currentUser.asObservable();
  }
}
