import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {RouterModule, Routes} from "@angular/router";
import {LoginComponent} from "../components/login/login.component";
import {UserListComponent} from "./components/user-list/user-list.component";


const routes: Routes = [
  { path: 'users', component: UserListComponent},
  // { path: 'users/:id', component: UserDetailsComponent},
  { path: 'login', component: LoginComponent}

]

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forChild(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class UserRoutingModule { }
