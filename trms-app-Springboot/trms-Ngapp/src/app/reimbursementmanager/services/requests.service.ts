import { map } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { LoginService } from './login.service';
import { Employee } from './../models/employee';
import { EmployeeService } from './employee.service';
import { Request } from './../models/requests';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RequestsService {

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
    return this.requestStore.userRequests.find(x => x.requestId==requestId);
  }
  headers = {'Content-type':'application/json'};  
  

   
  loadRequests(loggedInUser:Employee){
   // let employeeId = loggedInUser.employeeId;
    const url= "http://localhost:8080/Requests/";
    return this.http.get<Request[]>(url+loggedInUser.employeeId)
    .subscribe(data =>{
      this.requestStore.userRequests=data;
      this._requests.next(Object.assign({}, this.requestStore).userRequests)
    }, (err)=>{console.log("Failed to load");}
    );
  
    
   }

     
   

   
}
