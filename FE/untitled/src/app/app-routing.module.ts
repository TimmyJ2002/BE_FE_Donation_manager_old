import {RouterModule, Routes} from "@angular/router";
import {CommonModule} from "@angular/common";
import {NgModule} from "@angular/core";
import {PermissionManagementRoutingModule} from "./components/permission_management/permission-management-routing.module";
import {CreateDonatorComponent} from "./donator/components/createDonator/createdonator.component";
import {DonatorListComponent} from "./donator/components/donator-list/donator-list.component";
import {EditDonatorComponent} from "./donator/components/edit-donator/edit-donator.component";
import {DeleteDonatorComponent} from "./donator/components/delete-donator/delete-donator.component";


const routes: Routes = [
  { path: 'donator/create', component: CreateDonatorComponent },
  { path: 'donator/edit', component: DonatorListComponent },
  { path: 'donator/edit/:id', component: EditDonatorComponent,  },
  { path: 'donator/delete', component: DeleteDonatorComponent },
  { path: '', redirectTo: 'login', pathMatch: 'full'},
  { path: '**', redirectTo: 'login', pathMatch: 'full'}
];

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    PermissionManagementRoutingModule,
    RouterModule.forRoot(routes),
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule {

}
