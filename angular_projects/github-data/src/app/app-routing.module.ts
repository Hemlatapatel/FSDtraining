import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {UserComponent} from './components/user/user.component';
import {UserDetailComponent} from './components/user-detail/user-detail.component';


const routes: Routes = [
  {
    path: 'users',
    component: UserComponent
  },
  {
    path: 'user-detail',
    component: UserDetailComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
