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
<<<<<<<<< Temporary merge branch 1
import { UserChangePasswordComponent } from './user/components/user-change-password/user-change-password.component';
=========
import {CreateDonatorComponent} from "./donator/components/createDonator/createdonator.component";
import { DonatorRoutingModule } from './donator/donator-routing.module';
import { DonatorListComponent } from './donator/components/donator-list/donator-list.component';
import { EditDonatorComponent } from './donator/components/edit-donator/edit-donator.component';
>>>>>>>>> Temporary merge branch 2
// import { UserDetailsComponent } from './user/components/user-details/user-details.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
<<<<<<<<< Temporary merge branch 1
    UserChangePasswordComponent,
=========
    CreateDonatorComponent,
    DonatorListComponent,
    EditDonatorComponent
>>>>>>>>> Temporary merge branch 2
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
