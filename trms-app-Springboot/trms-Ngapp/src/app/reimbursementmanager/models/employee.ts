import { Request } from "./requests";

export class Employee {
    employeeId: number;
    firstName: string;
    lastName: string;
    managerId: number;
    departmentId: number;
    username: string;
    password:String;
    requests: Request[]=[];
   
}



