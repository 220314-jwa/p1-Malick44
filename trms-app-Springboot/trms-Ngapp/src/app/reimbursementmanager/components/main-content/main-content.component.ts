import { RequestsService } from './../../services/requests.service';
import { LoginService } from './../../services/login.service';
import { Component, OnInit } from '@angular/core';
import { Employee } from '../../models/employee';
import { ActivatedRoute } from '@angular/router';
import { Request } from '../../models/requests';

@Component({
  selector: 'app-main-content',
  templateUrl: './main-content.component.html',
  styleUrls: ['./main-content.component.scss']
})
export class MainContentComponent implements OnInit {
  loggedInUser:Employee ;
   userRequest: Request;
   

  constructor(private loginService:LoginService,
              private route: ActivatedRoute,
              private requestsService:RequestsService) { }

  ngOnInit(): void {
    this.route.params.subscribe(params =>{ 
      let requestId=params['requestId'];
      if (!requestId) requestId= 1;
      this.userRequest = null;


this.requestsService.userRequests.subscribe(userRequests => {
  if (userRequests.length == 0) return;

  setTimeout(() => {
    this.userRequest= this.requestsService.userRequestById(requestId);
  }, 500)

});

      this.loggedInUser=this.loginService.loggedInUser;
    })

    
    
   
  }

}
