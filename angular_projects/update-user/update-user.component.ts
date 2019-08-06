import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router, UrlSegment} from '@angular/router';
import {UsersService} from '../../services/users.service';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-update-user',
  templateUrl: './update-user.component.html',
  styleUrls: ['./update-user.component.scss']
})
export class UpdateUserComponent implements OnInit {
  user: any;
  id: any;
  formGroup: FormGroup;
  post: any;
  firstName: any;
  lastName: any;
  contact: any;
  email: any;
  address: any;
  // app = angular.module('myApp', []);


  constructor(private usersService: UsersService,
              private formBuilder: FormBuilder,
              private activatedRoute: ActivatedRoute,
              private router: Router
  ) {

    this.activatedRoute.url.subscribe((s: UrlSegment[]) => {
      console.log('url', s[1].path);
      this.id = s[1].path;
      this.usersService.getUserById(this.id)
          .subscribe(response => {
            this.user = response.json();
            this.firstName = this.user.firstName;
            this.lastName = this.user.lastName;
            this.contact = this.user.contact;
            this.email = this.user.email;
            // this.address = this.user.address;
            console.log('user at 32', this.user);
          })
    })
  }


  ngOnInit() {
    this.createForm();
  }


  createForm() {
    // const emailRegex: RegExp = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\;
    this.formGroup = this.formBuilder.group({
      'firstName': [null, [
        Validators.required,
        Validators.minLength(3),
        Validators.maxLength(15)
      ]],
      'lastName': [null, [Validators.required,
        Validators.minLength(3),
        Validators.maxLength(15)
      ]],
      'contact': [null,[Validators.required,
        Validators.minLength(10),
        Validators.maxLength(12)
      ]],
      'email': [null,[Validators.required,
        // Validators.pattern(emailRegex)
      ]],
      'address': [null,[Validators.required,
        Validators.minLength(3),
        Validators.maxLength(50)
      ]]
    })
  }


  onSubmit(post) {
    this.post = post;
    console.log('post===', post);
    this.updateUser(this.post)
  }

  updateUser(user) {
    user['roleId'] = 2;
    console.log('user at 71==', user);
    this.usersService.editUser(user)
        .subscribe(response => {
          console.log('response', response);
          this.router.navigate(['/user-list']);
        }, error => {
          console.log('error', error);
        })
  }
}
