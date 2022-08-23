import { Observable } from 'rxjs';
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
  loggedInUser:Employee;
  userRequests: Observable<Request[]>;

  ngOnInit(): void {
    this.breakpointObserver
    .observe([`(max-width: ${SMALL_WIDTH_BREAPOINT}PX)`])
    .subscribe((state:BreakpointState) => {
      this.isScreenSmall= state.matches;
    });
    this.userRequests= this.requestsService.userRequests;
    this.requestsService.loadRequests();
    this.userRequests.subscribe(data=>{console.log(data)},err=>{})
    this.loggedInUser= this.loginService.loggedInUser;
    console.log(this.userRequests);
   // console.log(this.loggedInUser);

    
  }

}
