import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { User } from './user.service';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  private baseUrl: string;
  private headers: HttpHeaders;

  constructor(private httpClient: HttpClient) {
    this.baseUrl = 'http://localhost:8081/api';
    this.headers = new HttpHeaders({
      'Authorization': 'Basic dXNlcjE6cGFzc3dvcmQ=',
      'Content-Type': 'application/json',
      'asd-fgh': 'lol'
    });
  }

  findAll<T>(namespace): Observable<T> {
    return this.httpClient.get<T>(this.baseUrl + namespace, {
      headers: this.headers
    });
  }

  findByNo<T>(namespace, no): Observable<T> {
    return this.httpClient.get<T>(this.baseUrl + namespace + '/' + no, {
      headers: this.headers
    });
  }

  deleteByNo(namespace, no): Observable<void> {
    return this.httpClient.delete<void>(this.baseUrl + namespace + '/' + no, {
      headers: this.headers
    });
  }

  putByNo<T>(namespace, no, model): Observable<T> {
    return this.httpClient.put<T>(this.baseUrl + namespace + '/' + no, model, {
      headers: this.headers
    });
  }

  handleError() {
    return throwError('WRONG_CREDENTIALS');
  }

  post<T>(namespace, model, user: User = null): Observable<T> {
    let headers = this.headers;
    
    if (user) {
      headers = headers.set('Authorization', 'Basic ' + btoa(user.username + ':' + user.password));
    }
    
    return this.httpClient.post<T>(this.baseUrl + namespace, model, { headers })
      .pipe(catchError(this.handleError));
  }
}
