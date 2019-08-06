import { Component } from '@angular/core';
import { isBoolean } from 'util';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'show-secret';

  showSecret = false;
  log = [];
  isDisable = true;

  constructor() {
      setTimeout(() => {
         this.isDisable  = false;
      }, 3000);

  }

  onToggleDetails() {
    this.showSecret = !this.showSecret;
    this.log.push(this.log.length);
  }
}
