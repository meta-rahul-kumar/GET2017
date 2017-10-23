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
import { ProductDetailComponent }  from '../productDetail/product-detail.component';
import { EditProductDetailComponent }  from '../editProduct/edit-product-detail.component';
import { ProductService} from '../products/product.service';
import { AddProductComponent }  from '../addProduct/add-product.component';
import {ProductSearchComponent} from '../productSearch/product-search.component';
import { FrontEndProductListComponent } from '../frontEnd/front-end.component';
import { FrontEndProductDetailComponent }  from '../frontEndProductDetail/front-end-product-detail.component';
import { StarRatingModule } from 'angular-star-rating';
import { LoginComponent } from '../login/login.component';
import { UserService } from '../userService/user.service';
import { NavBarComponent } from '../navBar/navbar.component';
import { CartService} from '../cartService/cart.service';
import { CartDetailComponent} from '../cartDetails/cart-detail.component';
import { CheckoutComponent } from  '../checkout/checkout';
import { OrderService } from '../orderService/order.service';
import { OrderComponent } from '../orders/order.component';
import { OrderDetailComponent }  from '../orderDetail/order-detail.component';

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
    LoginComponent,
    NavBarComponent,
    CartDetailComponent,
    CheckoutComponent,
    OrderComponent,
    OrderDetailComponent,
  ],
  imports: [
    BrowserModule, 
    AppRoutingModule,
    HttpModule,
    AppRoutingModule,
    FormsModule,
    StarRatingModule.forRoot()
  ],
  providers: [ProductService,UserService,CartService,OrderService],
  bootstrap: [AppComponent]
})
export class AppModule { }
