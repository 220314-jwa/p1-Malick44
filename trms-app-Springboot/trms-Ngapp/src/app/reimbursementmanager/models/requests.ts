import { Time } from "@angular/common";

export class Request {

    requestId: number;
    employeeId: number;
    eventTypeId: number;
    status_name: string;
    cost: number;
    eventDate: Date;
    description: string;
    location: string;
    submissionTime: Time;

}
