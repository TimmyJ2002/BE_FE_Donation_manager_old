import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppComponent} from './app.component';
import {LoginComponent} from './components/login/login.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {RouterModule, RouterOutlet} from "@angular/router";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {AppRoutingModule} from "./app-routing.module";
import {UserRoutingModule} from "./user/user-routing.module";
import {HttpClientModule} from "@angular/common/http";
import {CreateDonatorComponent} from "./donator/components/createDonator/createdonator.component";
import { DonatorRoutingModule } from './donator/donator-routing.module';
import { DonatorListComponent } from './donator/components/donator-list/donator-list.component';
import { EditDonatorComponent } from './donator/components/edit-donator/edit-donator.component';
// import { UserDetailsComponent } from './user/components/user-details/user-details.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    CreateDonatorComponent,
    DonatorListComponent,
    EditDonatorComponent
    // UserDetailsComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    UserRoutingModule,
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule,
    RouterOutlet,
    RouterModule,
    HttpClientModule,
  ],
  exports: [
    RouterModule,
    // UserDetailsComponent
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
