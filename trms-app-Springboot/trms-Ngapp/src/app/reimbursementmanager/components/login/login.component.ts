import { Router } from '@angular/router';
import { LoginService } from './../../services/login.service';
import { Employee } from './../../models/employee';
import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { JsonPipe } from '@angular/common';
import { outputAst } from '@angular/compiler';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
   // custom even emitter
  @Output() loginOrLogout: EventEmitter<any> = new EventEmitter();
  
  
  
  constructor(private loginService:LoginService, 
    private fb: FormBuilder,
    private routes: Router) { }
  loggedInUser: Employee;
  credentials: FormGroup;
  
 
  ngOnInit(): void {
    this.credentials= this.fb.group({
    username:'',
    password:''
  
    });

   //this.getLoggedInUser();

    
    
    //this.loggedInUser= this.loginService.checkLogin()
  }
  
  
async logIn(): Promise<void>{
  console.log(this.credentials.value)
  this.loggedInUser= await this.loginService.logIn(this.credentials.value);
  this.loginOrLogout.emit();
  //console.log(this.credentials.value)
  console.log(this.loggedInUser)
  this.routes.navigate(['/trmsapp/'])
  
  

  
}


async logOut(): Promise<void>{
  sessionStorage.removeItem('Auth-Token');
  this.loggedInUser=null;
  this.loginOrLogout.emit();

}

save(){
 // console.log('save: '+ JSON.stringify(this.credentials.getRawValue))
console.log(this.credentials.value);
}
}
