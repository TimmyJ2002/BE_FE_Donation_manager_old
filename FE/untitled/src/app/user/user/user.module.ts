import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {UserListComponent} from "../components/user-list/user-list.component";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {UserRoutingModule} from "../user-routing.module";
import {HttpClientModule} from "@angular/common/http";
import {AppModule} from "../../app.module";



@NgModule({
  declarations: [
    UserListComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    HttpClientModule,
    UserRoutingModule,
    ReactiveFormsModule,
    AppModule,
  ],
  exports: [
    UserListComponent
  ]
})
export class UserModule { }
