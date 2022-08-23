import { LoginService } from './services/login.service';

import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReimbursementmanagerAppComponent } from './reimbursementmanager-app.component';
import { ToolbarComponent } from './components/toolbar/toolbar.component';
import { SidenavComponent } from './components/sidenav/sidenav.component';
import { MainContentComponent } from './components/main-content/main-content.component';
import {  Routes, RouterModule } from '@angular/router';
import { SharedmaterialModule } from '../sharedmaterial.module';
import { ReactiveFormsModule } from '@angular/forms';
import { FlexLayoutModule } from '@angular/flex-layout';
import { EmployeeService } from './services/employee.service';
import { RequestsService } from './services/requests.service';
import { HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './components/login/login.component';



const routes: Routes=[
  {path: '', component: ReimbursementmanagerAppComponent, 
  children:[
    {path:'requests/:requestId', component: MainContentComponent},
    {path: 'login', component:LoginComponent}
   
  ] },

  {path: '**', redirectTo: ''}
];

@NgModule({
  declarations: [
    ReimbursementmanagerAppComponent,
    ToolbarComponent,
    SidenavComponent,
    MainContentComponent,
    LoginComponent,

  ],
  imports: [
    CommonModule,
    HttpClientModule,
    SharedmaterialModule,
    ReactiveFormsModule,
    FlexLayoutModule,
    RouterModule.forChild(routes)
  ],
  providers:[EmployeeService,
             RequestsService,LoginService]
})
export class ReimbursementmanagerModule { }
