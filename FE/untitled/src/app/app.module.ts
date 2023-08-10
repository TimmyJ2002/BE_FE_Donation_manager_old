import {NgModule} from "@angular/core";
import {BrowserModule} from '@angular/platform-browser';

import {AppComponent} from './app.component';
import {LoginComponent} from './components/login/login.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {AppRoutingModule} from "./app-routing.module";
import {UserRoutingModule} from "./user/user-routing.module";
import {HttpClientModule} from "@angular/common/http";
import { CampaignEditComponent } from './campaign/component/campaign-edit/campaign-edit.component';
import { CampaignDeleteComponent } from './campaign/component/campaign-delete/campaign-delete.component';
// import { UserDetailsComponent } from './user/components/user-details/user-details.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    CampaignEditComponent,
    CampaignDeleteComponent,
    // UserDetailsComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    UserRoutingModule,
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
  ],
  exports: [
    // UserDetailsComponent
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
