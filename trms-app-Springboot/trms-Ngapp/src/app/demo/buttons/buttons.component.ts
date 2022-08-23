import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-buttons',
  template: `<mat-checkbox class="example-margin">Check me!</mat-checkbox>`,
  styles:[]
  
})
export class ButtonsComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

}
