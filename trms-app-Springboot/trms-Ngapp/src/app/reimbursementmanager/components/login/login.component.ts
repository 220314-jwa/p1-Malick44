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
  
  
  constructor(private loginService:LoginService, private fb: FormBuilder) { }
  loggedInUser: Employee;
  credentials: FormGroup;
  
 
  ngOnInit(): void {
    this.credentials= this.fb.group({
    username:'',
    password:''

    });
    //this.getLoggedInUser();
  }


async logIn(): Promise<void>{
  this.loggedInUser= await this.loginService.login(this.credentials.value);
  this.loginOrLogout.emit();
  console.log(this.loggedInUser);
}

async logOut(): Promise<void>{
  sessionStorage.removeItem('Auth-Token');
  this.loginOrLogout.emit();

}
save(){
 // console.log('save: '+ JSON.stringify(this.credentials.getRawValue))
console.log(this.credentials.value);
}
}
