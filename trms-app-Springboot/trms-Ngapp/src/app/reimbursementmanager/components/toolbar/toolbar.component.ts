import { HttpClient } from '@angular/common/http';
import { RequestsService } from './../../services/requests.service';
import { LoginService } from './../../services/login.service';
import { Component, OnInit, Output, EventEmitter, Input } from '@angular/core';
import { Employee } from '../../models/employee';
import { Request } from '../../models/requests';
import { catchError, EMPTY, tap } from 'rxjs';

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
     ) { }
  loggedInUser:Employee;
 loggedInuser$= this.loginService.loggedInuser$
 .pipe(
  catchError( err =>{
    this.errorMessage=err;
    return EMPTY;
  })
 );

  ngOnInit(): void {
 console.log(this.loggedInUser);
    //this.loggedInUser= null;
  }
  // async getLoggedInUser() {
  //   this.loggedInUser = await this.loginService.checkLogin();
  // }
  logOut(): void {
   // console.log(this.loggedInUser)
    
    sessionStorage.removeItem('Auth-Token');
    this.loggedInUser=null;
    // firing the custom event
    this.loginOrLogout.emit();
    console.log(sessionStorage.getItem('Auth-Token'))
    //console.log(this.loggedInUser)
  }
  logheck(): void {
   // this.loginService.checkLogin();
    //this.getLoggedInUser();
    //console.log(this.loggedInUser)
    // firing the custom event
    this.loginOrLogout.emit();
    
  }

  
  

}
