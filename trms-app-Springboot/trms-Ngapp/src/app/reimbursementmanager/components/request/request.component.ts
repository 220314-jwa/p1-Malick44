import { RequestsService } from './../../services/requests.service';
import { RegisterService } from './../../services/register.service';
import { Routes, Router } from '@angular/router';
import { FormBuilder,  FormGroup, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-request',
  templateUrl: './request.component.html',
  styleUrls: ['./request.component.scss']
})

export class RequestComponent implements OnInit {
  addRequestForm : FormGroup;
  pageTitle = 'SubmitRequest';
  errorMessage:string
  displayMessage:{[key:string]: string}={}
  userRequest:Request
  private sub: Subscription;
  //private validationMessages:{[key:string]:{[key:string]:string}};
    private validationMessages:{[key:string]:{[key:string]:string}};
 // genericValidator: GenericValidator;


  constructor(private fb:FormBuilder,
              private routes: Router,
              private requestsService:RequestsService) {
                this.validationMessages={
                  employeeId:{
                               required:'EmployeeId is required'},
                   eventname:{
                               required:'Eventname is required'}
                }
               // this.genericValidator = new GenericValidator(this.validationMessages);
               };

             

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

  editRequest():void{

  }

  deleteRequest():void{
    //if(this.request.r){}

  }
  onSaveComplete():void{
    this.addRequestForm.reset();
    this.routes.navigate(['/request']);

  }
}
 









