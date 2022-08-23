import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {  RouterModule, Routes } from '@angular/router';


import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';


const routes: Routes=[
  {path: 'trmsapp', loadChildren:() => import('./reimbursementmanager/reimbursementmanager.module').then(m => m.ReimbursementmanagerModule)},
  {path: 'demo', loadChildren:() => import('./demo/demo.module').then(m => m.DemoModule)},

  {path: '**', redirectTo: 'trmsapp'}
];

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
