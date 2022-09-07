import { FormBuilder, FormGroup } from '@angular/forms';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
  
  pageTitle= "Register";
  errorMessage= " ";
  registrationForm: FormGroup;
  routes: any;
  constructor(private fb:FormBuilder) { }
  register():void{
    this.routes.navigate(['/trmsapp/register'])
  }
  logIn(): void{
    this.routes.navigate(['/trmsapp/login'])
  }

  ngOnInit(): void {
    this.registrationForm= this.fb.group({
      firstname: '',
      lastname:'',
      email:'',
      username:'',
      password:''
    
    })



  }

}
