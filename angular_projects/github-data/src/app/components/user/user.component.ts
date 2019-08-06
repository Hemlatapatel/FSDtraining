import { Component, OnInit } from '@angular/core';
import {UserService} from '../../services/user.service';
import {User} from '../../models/user.model';


// @ts-ignore
@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  user: any[];

  // tslint:disable-next-line:ban-types
  users: any[];
  constructor(private service: UserService) { }

  ngOnInit() {
   this.getUsers();
  }

  getUsers() {

    this.service.getUsers().subscribe(response => {
      this.users = response.json();
    }, error => {
      alert('Error occured' + error);
    });
  }
}
