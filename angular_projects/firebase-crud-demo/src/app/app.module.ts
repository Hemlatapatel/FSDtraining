import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {AngularFireModule} from '@angular/fire';
import {AngularFireDatabaseModule} from '@angular/fire/database';
import { environment } from '../environments/environment';
import {initializeApp} from 'firebase';
import {PolicyService} from './services/policy.service';
import { PolicyListComponent } from './components/policy-list/policy-list.component';
import {AngularFirestore, AngularFirestoreModule} from '@angular/fire/firestore';
import {FormsModule} from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    PolicyListComponent
  ],
  providers: [PolicyService],
  imports: [
    BrowserModule,
    AppRoutingModule,
    AngularFireModule.initializeApp(environment.firebaseConfig),
    AngularFireDatabaseModule,
    AngularFirestoreModule,
    FormsModule

  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
