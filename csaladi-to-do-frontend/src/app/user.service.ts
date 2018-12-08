import { Injectable } from '@angular/core';
import { ApiService } from './api.service';
import { Observable } from 'rxjs';

export type User = {
  username: string,
  password: string,
  firstName?: string
};

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private apiService: ApiService) { }

  signIn(user: User): Observable<User> {
    return this.apiService.post<User>('/users/sign-in', user, user);
  }
}
