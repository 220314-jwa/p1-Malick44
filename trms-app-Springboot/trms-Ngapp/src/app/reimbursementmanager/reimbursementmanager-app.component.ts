import { Component, OnInit } from '@angular/core';
import { MatIconRegistry } from '@angular/material/icon';
import { DomSanitizer } from '@angular/platform-browser';

@Component({
  selector: 'app-reimbursementmanager-app',
  template:`
  <app-sidenav></app-sidenav>
  `,
  styleUrls: []
})
export class ReimbursementmanagerAppComponent implements OnInit {

  constructor(inconResidtry:MatIconRegistry, sanitizer:DomSanitizer) {
    inconResidtry.addSvgIconSet
   }

  ngOnInit(): void {
  }

}
