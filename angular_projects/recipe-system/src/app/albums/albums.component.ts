import { Component, OnInit } from '@angular/core';
import { Http } from '@angular/http';

@Component({
  selector: 'app-albums',
  templateUrl: './albums.component.html',
  styleUrls: ['./albums.component.css']
})
export class AlbumsComponent implements OnInit {

  private url = 'http://localhost:8011/project-service/api/projects';

  private customerUrl = "http://localhost:3000/api/customers";

  private projects: any[];

  constructor(private http: Http) {
    console.log('in constructor')
    http.get(this.customerUrl)
      .subscribe(response => {

        // this.projects = response.json();
        console.log("response", response.json());
        // response.json();
      })
  }

  ngOnInit() {
  }


  createCustomer( input: HTMLInputElement) {
    let customers: any;

    customers = {title: input.value};

    this.http.post(this.customerUrl, customers)
    .subscribe(response => {
      
    })

    
  }
}
