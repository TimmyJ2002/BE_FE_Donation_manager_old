import {RouterModule, Routes} from "@angular/router";
import {CommonModule} from "@angular/common";
import {NgModule} from "@angular/core";
import {CreateDonatorComponent} from "./donator/components/createDonator/createdonator.component";

const routes: Routes = [
  { path: 'donator/create', component: CreateDonatorComponent },
  { path: 'donator/edit', component: CreateDonatorComponent },
  { path: 'donator/delete', component: CreateDonatorComponent },
  { path: '', redirectTo: 'login', pathMatch: 'full'},
  { path: '**', redirectTo: 'login', pathMatch: 'full'}
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
