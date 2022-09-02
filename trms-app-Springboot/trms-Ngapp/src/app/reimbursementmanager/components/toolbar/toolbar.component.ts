import { Router, Routes } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { RequestsService } from './../../services/requests.service';
import { LoginService } from './../../services/login.service';
import { Component, OnInit, Output, EventEmitter, Input } from '@angular/core';
import { Employee } from '../../models/employee';
import { Request } from '../../models/requests';
import { catchError, EMPTY, map } from 'rxjs';

@Component({
  selector: 'app-toolbar',
  templateUrl: './toolbar.component.html',
  styleUrls: ['./toolbar.component.scss']
})
export class ToolbarComponent implements OnInit {
  @Output() toggleSidenav = new EventEmitter<void>();
  @Output() loginOrLogout: EventEmitter<any> = new EventEmitter();
  errorMessage: any;
 


  constructor(private loginService:LoginService, 
    private requestsService: RequestsService,
     private http:HttpClient,
     private routes: Router     ) { }
  //loggedInUser:Employee| undefined;
loggedInUser$= this.loginService.loggedInuser$
 .pipe( 
  catchError( err =>{
    this.errorMessage=err;
    return EMPTY;
  })
 );

  ngOnInit(): void {

  }
 
  
  logOut(): void {
   // console.log(this.loggedInUser)
    
    sessionStorage.removeItem('Auth-Token');
    // firing the custom event
    this.loginOrLogout.emit();
    console.log(sessionStorage.getItem('Auth-Token'))
    //console.log(this.loggedInUser)
   this.routes.navigate(['/trmsapp'])
    
  }
  logIn(): void{
    //this.loggedInUser=null;
    this.routes.navigate(['/trmsapp/login'])
  }
  register(): void{
    this.routes.navigate(['/trmsapp/register'])
  }
  logheck(): void {
   // this.loginService.checkLogin();
    //this.getLoggedInUser();
   
    console.log(sessionStorage.getItem('Auth-Token'))
   
    // firing the custom event
    this.loginOrLogout.emit();
    
  }

  
  

}
