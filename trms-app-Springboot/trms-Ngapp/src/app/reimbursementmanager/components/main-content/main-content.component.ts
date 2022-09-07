import { RequestsService } from './../../services/requests.service';
import { LoginService } from './../../services/login.service';
import { Component, OnInit } from '@angular/core';
import { Employee } from '../../models/employee';
import { ActivatedRoute, Router } from '@angular/router';
import { Request } from '../../models/requests';
import { FormGroup, Validators, FormBuilder } from '@angular/forms';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-main-content',
  templateUrl: './main-content.component.html',
  styleUrls: ['./main-content.component.scss']
})
export class MainContentComponent implements OnInit {
  loggedInUser:Employee ;
   userRequest: Request;
   addRequestForm : FormGroup;
   pageTitle = 'SubmitRequest';
   errorMessage:string
   displayMessage:{[key:string]: string}={}
   private sub: Subscription;
   private validationMessages:{[key:string]:{[key:string]:string}};
   

  constructor(private loginService:LoginService,
              private route: ActivatedRoute,
              private routes:Router,
              private fb: FormBuilder,
              private requestsService:RequestsService) {
                this.validationMessages={
                  employeeId:{
                               required:'EmployeeId is required'},
                   eventname:{
                               required:'Eventname is required'}
                }
               }

//loggedInUser$= this.loginService.loggedInUser;

  ngOnInit(): void {
    
    this.addRequestForm= this.fb.group({
      requestId:['',[Validators.required]],
      employeeId:['',[Validators.required]],
      eventTypeId:['',[]],
      cost:['',[Validators.required]],
      eventDate:['',[]],
      description:['',[]],
      location:['',[]]
          });

   // this.getLoggedInUser();
    this.route.params.subscribe(params =>{ 
      let requestId=params['requestId'];
      if (!requestId) requestId= 1;
      this.userRequest = null;
this.requestsService.userRequests.subscribe(userRequests => {
  if (userRequests.length == 0) return;

  setTimeout(() => {
    this.userRequest= this.requestsService.userRequestById(requestId);
    this.sowRequest(this.userRequest)
  }, 500)

});
   //console.log(this.loggedInUser);  
      
    })

  
   
  }

  sowRequest(userRequest:Request):void{
    if(this.addRequestForm){this.addRequestForm.reset();}
   this.userRequest=userRequest;
   if(this.userRequest.requestId===0){
    this.pageTitle = 'Submit Request'
   }else{
    this.pageTitle = `Edit Request: ${userRequest.description}`
   }

   this.addRequestForm.patchValue({
    requestId: this.userRequest.requestId,
      employeeId: this.userRequest.employeeId,
      eventTypeId:this.userRequest.eventTypeId,
      cost: this.userRequest.cost,
      eventDate:this.userRequest.eventDate,
      description:this.userRequest.description,
      location:this.userRequest.location
   })
  }
  

  saveRequest(): void{
    const r ={...this.userRequest, ...this.addRequestForm.value};
    if(r.rquestId===0){
      this.requestsService.createRequest(r)
      .subscribe({
        next: ()=> this.onSaveComplete(),
        error: err => this.errorMessage=err
      })

    }else {
      this.requestsService.editRequest(r)
      .subscribe({
        next:() =>this.onSaveComplete(),
        error: err => this.errorMessage=err
      })
    }
   
    
   
   
  }

  

  deleteRequest():void{
    //if(this.request.r){}

  }
  onSaveComplete():void{
    this.addRequestForm.reset();
    this.routes.navigate(['/request']);

  }

}
