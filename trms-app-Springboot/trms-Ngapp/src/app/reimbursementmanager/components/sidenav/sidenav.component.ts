import { Observable, catchError, EMPTY, tap } from 'rxjs';
import { RequestsService } from './../../services/requests.service';
import { LoginService } from './../../services/login.service';
import { Employee } from './../../models/employee';
import { EmployeeService } from './../../services/employee.service';
import { state } from '@angular/animations';
import { BreakpointObserver, BreakpointState } from '@angular/cdk/layout';
import { Component, OnInit } from '@angular/core';
import { Request } from '../../models/requests';


const SMALL_WIDTH_BREAPOINT=720;
@Component({
  selector: 'app-sidenav',
  templateUrl: './sidenav.component.html',
  styleUrls: ['./sidenav.component.scss']
})
export class SidenavComponent implements OnInit {
  constructor(private breakpointObserver:BreakpointObserver,
    private loginService :LoginService, 
    private requestsService:RequestsService) { }

  public isScreenSmall: boolean=false;
  shouldRun = /(^|.)(stackblitz|webcontainer).(io|com)$/.test(window.location.host);
  
  userRequests: Observable<Request[]>;
  loggedIndUser:Employee;
  errorMessage: string
  
  // loggedInuser$= this.loginService.loggedInuser$
  // .pipe(
  //   tap(
  //     data =>{this.loggedIndUser=data}
  //   ),
  //  catchError( err =>{
  //    this.errorMessage=err;
  //    return EMPTY;
  //  })
  // );

  ngOnInit(): void {
   

  
    this.breakpointObserver
    .observe([`(max-width: ${SMALL_WIDTH_BREAPOINT}PX)`])
    .subscribe((state:BreakpointState) => {
      this.isScreenSmall= state.matches;
    });
    
    this.requestsService.loadRequests();
    this.userRequests= this.requestsService.userRequests;
    console.log(this.userRequests);
    //this.loggedInUser= this.loginService.loggedInUser;
  }
   // this.loginService._loggedInUser.subscribe(data =>{
    //   this.loggedInUser=data;
    // });
    

}
