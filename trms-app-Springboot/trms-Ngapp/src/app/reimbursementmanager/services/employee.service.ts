import { LoginService } from './login.service';
import { Employee } from './../models/employee';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  url: string= "http://localhost:8080/Requests/4";
  private dataStore:{
    employees:Employee[]
  }
  loggedInUser :Employee = new Employee();

  constructor(private http: HttpClient, private loginService:LoginService) {
    this.dataStore={employees:[]};
   }
   getAllEmployees(){
   const employeesUrl =`http://localhost:8080/Employees`;
   return this.http.get<Employee[]>(employeesUrl)
   .subscribe(data =>{
    this.dataStore.employees=data;
   }, error =>{console.log("Failed to fectch data")});
   
  }
  


}
