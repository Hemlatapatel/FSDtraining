import { Component, OnInit } from '@angular/core';
import {PolicyService} from '../../services/policy.service';
import {Policy} from '../../models/policy.model';

@Component({
  selector: 'app-policy-list',
  templateUrl: './policy-list.component.html',
  styleUrls: ['./policy-list.component.css']
})
export class PolicyListComponent implements OnInit {

  policy: Policy;
  policies: Policy[];
  constructor(private service: PolicyService) { }

  ngOnInit() {
    this.service.getPolicies().subscribe(data => {
      this.policies = data.map(e => {
        return {
          id: e.payload.doc.id,
          ...e.payload.doc.data()
        } as Policy;
      });
    });
  }

}
