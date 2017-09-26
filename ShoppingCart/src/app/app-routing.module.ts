import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
 
import { AppComponent }   from './app.component';
import { DashboardComponent }   from '../dashboard/dashboard.component';
import { ContactComponent }      from '../contact/contact.component';
import { ProductListComponent }  from '../products/productlist.component';
import { ProductDetailComponent }  from '../productDetail/product-detail.component';
import { EditProductDetailComponent }  from '../editProduct/edit-product-detail.component';
import { AddProductComponent }  from '../addProduct/add-product.component';
import { FrontEndProductListComponent } from '../frontEnd/front-end.component';
import { FrontEndProductDetailComponent }  from '../frontEndProductDetail/front-end-product-detail.component';
 
const routes: Routes = [
  { path: '', redirectTo: '/dashboard', pathMatch: 'full' },
  { path: 'dashboard',  component: DashboardComponent },
  { path: 'contact', component: ContactComponent },
  { path: 'products', component: ProductListComponent },
  { path: 'detail/:id', component: ProductDetailComponent },
  { path: 'edit-product/:id', component: EditProductDetailComponent },
  { path: 'add-product', component: AddProductComponent },
  { path: 'home', component: FrontEndProductListComponent },
  { path: 'product-detail/:id', component: FrontEndProductDetailComponent },
];
 
@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}