import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {AppModule} from "../app.module";
import {DonatorComponent} from "./components/donator/donator.component";
import {DonatorRoutingModule} from "./donator-routing.module";



@NgModule({
  declarations: [
    DonatorComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    HttpClientModule,
    DonatorRoutingModule,
    ReactiveFormsModule,
    AppModule,
  ],
  exports: [
  ]
})
export class DonatorModule { }
