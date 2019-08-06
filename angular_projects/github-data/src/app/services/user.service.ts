import { Injectable } from '@angular/core';
import { Http} from '@angular/http';
import {Observable} from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class UserService {
  url = 'https://api.github.com/users/mojombo/followers';
  private handleError: 'Error';

  constructor(private http: Http) { }

  getUsers() {
  return this.http.get(this.url);
    // .map(response => response.json())
    // .catch('error');
  }
}
