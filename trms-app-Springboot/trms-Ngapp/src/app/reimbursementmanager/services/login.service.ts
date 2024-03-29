import { Router } from '@angular/router';
import { Employee } from './../models/employee';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, throwError, catchError, tap, map, EMPTY } from 'rxjs';
import { ReturnStatement } from '@angular/compiler';


@Injectable({
  providedIn: 'root'
})
export class LoginService {
  constructor(private http: HttpClient,
              private routes:Router) { }
  
  user = new BehaviorSubject(sessionStorage.getItem('Auth-Token'));
  errMessage:string;
  headers = {'Content-type':'application/json'};
  //_loggedInUser:BehaviorSubject<Employee>;
  url: string= "http://localhost:8080/Employees/";
  
  

async logIn(credentials:any): Promise<Employee> {
let credentialJson= JSON.stringify(credentials);
 let httpResp= await fetch(this.url+"Auth", { method:'POST', body:credentialJson,headers:this.headers});
 if(httpResp && httpResp.status===200){
  let emp= await httpResp.json();
  sessionStorage.setItem('Auth-Token', emp.employeeId.toString().trim());
  this.user.next(sessionStorage.getItem('Auth-Token'));
  
 return emp;
 } else return null;
 

  }
  //id:number= <number><unknown>sessionStorage.getItem('Auth-Token')
 


// async checkLogin(): Promise<Employee>{
//   let id= <number><unknown>sessionStorage.getItem('Auth-Token')
//       let httpResp= await fetch(this.url,{method:'get',headers: this.headers});
//         if(httpResp && httpResp.status===200){
          
//           return await httpResp.json();
//         }else 
//         return null;
    

//    //return this.loggedInUser;
// }

 id = <number><unknown>sessionStorage.getItem('Auth-Token')

loggedInuser$ = this.http.get<Employee>(this.url+this.id).pipe(
  tap(data => console.log('employee',JSON.stringify(data))),
  //map( data => this.loggedInUser=data),
  catchError(this.handleError)
)
// isLogged():Promise<void>{

//   let _userToken= sessionStorage.getItem('Auth-Token');
//   console.log(_userToken);
//   let result:boolean= true;
//   return null;
// }
private handleError(err: HttpErrorResponse): Observable<never> {
  // in a real world app, we may send the server to some remote logging infrastructure
  // instead of just logging it to the console
  let errorMessage: string;
  if (err.error instanceof ErrorEvent) {
    // A client-side or network error occurred. Handle it accordingly.
    errorMessage = `An error occurred: ${err.error.message}`;
  } else {
    // The backend returned an unsuccessful response code.
    // The response body may contain clues as to what went wrong,
    errorMessage = `Backend returned code ${err.status}: ${err.message}`;
  }
  console.error(errorMessage);
  return throwError(() => errorMessage);
}
}
