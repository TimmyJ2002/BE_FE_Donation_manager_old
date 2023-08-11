import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {PermissionManagementComponent} from "../components/permission-management/permission-management.component";
import {RouterModule, Routes} from "@angular/router";

const routes: Routes = [
  { path: 'rights', component: PermissionManagementComponent}
];

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
export class PermissionManagementRoutingModule { }
