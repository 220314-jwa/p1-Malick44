import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SharedmaterialModule } from '../sharedmaterial.module';
import { ButtonsComponent } from './buttons/buttons.component';

import { DemoRoutingModule } from './demo-routing.module';
import { FormsModule } from '@angular/forms';
import { FlexboxComponent } from './flexbox.component';
import { FlexLayoutModule } from '@angular/flex-layout';


@NgModule({
  declarations: [
    ButtonsComponent,
    FlexboxComponent,
  ],
  imports: [
    CommonModule,
    DemoRoutingModule,
    FormsModule,
    SharedmaterialModule,
    FlexLayoutModule
 
  
  ]
})
export class DemoModule { }
