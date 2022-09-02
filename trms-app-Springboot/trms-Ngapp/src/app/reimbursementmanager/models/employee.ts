import { Request } from "./requests";

export interface Employee {
    employeeId: number;
    firstName?: string;
    lastName?: string;
    managerId?: number;
    departmentId?: number;
    username: string;
    password:String;
   
}



