import {RouterModule, Routes} from "@angular/router";
import {CommonModule} from "@angular/common";
import {NgModule} from "@angular/core";
import {UserCreationComponent} from "./user/components/user-creation/user-creation.component";


const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full'},
  /*{ path: '**', redirectTo: 'login', pathMatch: 'full'},*/
  { path: 'create-user', component: UserCreationComponent }
];

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes),
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule {

}
