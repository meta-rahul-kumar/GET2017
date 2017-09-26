import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { RouterModule }   from '@angular/router';
import { AppRoutingModule } from './app-routing.module';
import { ContactComponent } from '../contact/contact.component';
import { DashboardComponent } from '../dashboard/dashboard.component';
import { ProductListComponent }  from '../products/productlist.component';
import { HttpModule }    from '@angular/http';
import { InMemoryWebApiModule } from 'angular-in-memory-web-api';
import { InMemoryDataService }  from '../products/in-memory-data.service';
import { ProductDetailComponent }  from '../productDetail/product-detail.component';
import { EditProductDetailComponent }  from '../editProduct/edit-product-detail.component';
import { ProductService} from '../products/product.service';
import { AddProductComponent }  from '../addProduct/add-product.component';
import {ProductSearchComponent} from '../productSearch/product-search.component';
import { FrontEndProductListComponent } from '../frontEnd/front-end.component';
import { FrontEndProductDetailComponent }  from '../frontEndProductDetail/front-end-product-detail.component';
import { StarRatingModule } from 'angular-star-rating';


@NgModule({
  declarations: [
    AppComponent,
    ContactComponent,
    DashboardComponent,
    ProductListComponent,
    ProductDetailComponent,
    EditProductDetailComponent,
    AddProductComponent,
    ProductSearchComponent,
    FrontEndProductListComponent,
    FrontEndProductDetailComponent,
  ],
  imports: [
    BrowserModule, 
    AppRoutingModule,
    HttpModule,
    InMemoryWebApiModule.forRoot(InMemoryDataService),
    AppRoutingModule,
    FormsModule,
    StarRatingModule.forRoot()
  ],
  providers: [ProductService],
  bootstrap: [AppComponent]
})
export class AppModule { }
