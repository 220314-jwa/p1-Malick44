import { map,tap } from 'rxjs/operators';
import { Observable, catchError, throwError } from 'rxjs';
import { LoginService } from './login.service';
import { Employee } from './../models/employee';
import { EmployeeService } from './employee.service';
import { Request } from './../models/requests';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RequestsService {
  loggedInUser: Employee;

  private requestStore: {userRequests: Request[]};
  private _requests: BehaviorSubject<Request[]>
  constructor(private http: HttpClient,
              private empServ: EmployeeService,private loginService: LoginService) {
                this.requestStore = { userRequests:[]};
                this._requests = new BehaviorSubject<Request[]>([]);
               
              // this.loggedInUser.employeeId=4;
               
               
 
   }
   
   get userRequests(): Observable<Request[]>{
    return this._requests.asObservable();
   }
   
   userRequestById(requestId:number):Request{
    if (requestId === 0) {
      return (this.initializeRequest());
    }
    return this.requestStore.userRequests.find(x => x.requestId==requestId);
  }
  headers = new HttpHeaders({'Content-type':'application/json'});  
  
url= "http://localhost:8080/Requests/";
   
  loadRequests(){
let employeeId = sessionStorage.getItem('Auth-Token');
  let url= "http://localhost:8080/Requests/";
    return this.http.get<Request[]>(url+employeeId)
    .subscribe(
      data =>{
      this.requestStore.userRequests=data;
      this._requests.next(Object.assign({}, this.requestStore).userRequests)
    }, (err)=>{console.log("Failed to load");}
    );
  
    
   }
   createRequest(request:Request):Observable<Request>{
   return this.http.post<Request>(this.url, request, {headers:this.headers})
   .pipe(
    tap(() =>console.log('request upadared'+ request.description)),
    map(() => request),
    catchError(this.handleError));
  }

  editRequest(request:Request):Observable<Request>{
    const requesturl= `${this.url}${request.requestId}`;
    return this.http.post<Request>(requesturl, request, {headers:this.headers})
    .pipe(
     tap(() =>console.log('request upadated'+ request.description)),
     map(() => request),
     catchError(this.handleError));

  }

  deleteRequest(requestId:number):Observable<{}>{
    const requesturl= `${this.url}/${requestId}`;
    return this.http.delete<Request>(requesturl,  {headers:this.headers})
    .pipe(
     tap(() =>console.log('request upadared'+ requestId)),
     catchError(this.handleError));

  }

   private initializeRequest():Request{
    return {
requestId:0,
employeeId:0 ,
eventTypeId:0,
cost:0,
eventDate:null,
location:null,
description:null,
};
    
   }
   private handleError(err): Observable<never> {
    // in a real world app, we may send the server to some remote logging infrastructure
    // instead of just logging it to the console
    let errorMessage: string;
    if (err.error instanceof ErrorEvent) {
      // A client-side or network error occurred. Handle it accordingly.
      errorMessage = `An error occurred: ${err.error.message}`;
    } else {
      // The backend returned an unsuccessful response code.
      // The response body may contain clues as to what went wrong,
      errorMessage = `Backend returned code ${err.status}: ${err.body.error}`;
    }
    console.error(err);
    return throwError(errorMessage);
  }
}
