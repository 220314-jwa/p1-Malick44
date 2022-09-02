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
  constructor(private fb:FormBuilder) { }
  register():void{}

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
