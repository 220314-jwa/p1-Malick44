import { HttpClient } from '@angular/common/http';
import { RequestsService } from './../../services/requests.service';
import { LoginService } from './../../services/login.service';
import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { Employee } from '../../models/employee';
import { Request } from '../../models/requests';

@Component({
  selector: 'app-toolbar',
  templateUrl: './toolbar.component.html',
  styleUrls: ['./toolbar.component.scss']
})
export class ToolbarComponent implements OnInit {
  @Output() toggleSidenav = new EventEmitter<void>();
  @Output() loginOrLogout: EventEmitter<any> = new EventEmitter();
 


  constructor(private loginService:LoginService, private requestsService: RequestsService, private http:HttpClient) { }
  loggedInUser:Employee;
 

  async getLoggedInUser() {
    this.loggedInUser= await this.loginService.checkLogin();
    
    
  }
 
  logOut(): void {
    sessionStorage.removeItem('Auth-Token');
    this.loggedInUser=null;
    // firing the custom event
    this.loginOrLogout.emit();
  }

  ngOnInit(): void {
    this.getLoggedInUser();
    console.log(this.loggedInUser.lastName);
    console.log("now");
  }

}
