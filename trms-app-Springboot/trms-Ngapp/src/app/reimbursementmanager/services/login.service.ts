import { Employee } from './../models/employee';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  constructor(private http: HttpClient) { }
  url: string= "http://localhost:8080/Employees/";
  private loggedInUser:Employee;
  headers = {'Content-type':'application/json'};
  

  async login(credentials:any): Promise<Employee> {
let credentialJson= JSON.stringify(credentials);
 let httpResp= await fetch(this.url+"Auth", { method:'POST', body:credentialJson,headers:this.headers});
 if(httpResp && httpResp.status===200){
  this.loggedInUser= await httpResp.json();
  sessionStorage.setItem('Auth-Token', this.loggedInUser.employeeId.toString());
  console.log(sessionStorage.getItem('Auth-Token'));
 
 } 
return this.loggedInUser;
  }

async checkLogin(): Promise<any>{
  let employeeId = sessionStorage.getItem('Auth-Token');

    if(employeeId){
      let httpResp= await fetch(this.url+employeeId,{headers: this.headers});
        if(httpResp && httpResp.status===200){
          return await httpResp.json();
        }else {return null};
    }
}

}
