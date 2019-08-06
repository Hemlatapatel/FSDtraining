import { Component, OnInit } from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
import {Http, HttpModule} from '@angular/http';
import { Customer } from '../../models/Customer';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})


export class CustomerListComponent implements OnInit {

  url = 'http://localhost:8031/customer-service/api/customers';
  customers: any;
  isForm = false;
  customer = new Customer();

  constructor(private http: Http) {

    this.displayCustomers();
  }

  ngOnInit() {
  }

  onAddCustomer() {
     this.isForm = true;
  }

  displayCustomers() {
    this.http.get(this.url)
      .subscribe(response => {
        this.customers = response.json();
      });
  }
  // @ts-ignore
  addCustomer(customer) {
    if (customer.id) {
      this.http.put(this.url, customer)
        .subscribe(response => {
          this.displayCustomers();
        });
    } else {
      this.http.post(this.url, customer)
        .subscribe(response => {
          this.displayCustomers();
        });
    }

    this.isForm = false;
  }

  updateCustomer(customer: any) {
    this.isForm = true;
    this.customer = customer;
  }

  deleteCustomer(customer: any) {
    this.http.delete(this.url + '/' + customer.id)
      .subscribe(response => {
        console.log(response);
        this.displayCustomers();
      });
  }
}
