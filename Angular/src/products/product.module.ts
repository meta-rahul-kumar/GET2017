import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { ProductListComponent } from './productlist.component';
import { RouterModule }   from '@angular/router';

@NgModule({
  declarations: [
    ProductListComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [ProductListComponent]
})
export class AppModule { }
