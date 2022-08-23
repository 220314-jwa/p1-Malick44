import { Employee } from './../models/employee';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  constructor(private http: HttpClient) { }
  url: string= "http://localhost:8080/Employees/";
  loggedInUser:Employee= new Employee();
  headers = {'Content-type':'application/json'};
  

  async login(credentials:any): Promise<Employee> {
let credentialJson= JSON.stringify(credentials);
 let httpResp= await fetch(this.url+"Auth", { method:'POST', body:credentialJson,headers:this.headers});
 if(httpResp && httpResp.status===200){
  this.loggedInUser= await httpResp.json();
  sessionStorage.setItem('Auth-Token', this.loggedInUser.employeeId.toString());
 } 
return this.loggedInUser;
  }
async checkLogin(): Promise<Employee>{
 let userId = sessionStorage.getItem('Auth-Token')
if(userId){ 
  let httpResp = await fetch(this.url+'Employees/'+userId, {headers: this.headers});
if (httpResp && httpResp.status===200)
{
  return await  httpResp.json()}
} 
return this.loggedInUser=null;
} 
}
