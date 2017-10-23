import 'rxjs/add/operator/switchMap';
import { Component, OnInit }        from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { Location }                 from '@angular/common';

import { Product }        from '../products/product';
import { ProductService } from '../products/product.service';
import { CartService} from '../cartService/cart.service';
import { Message} from '../models/message';

@Component({
  selector: 'front-end-product-detail',
  templateUrl: './front-end-product-detail.component.html',
  styleUrls: [ './front-end-product-detail.component.css' ]
})

export class FrontEndProductDetailComponent implements OnInit {
  product: Product;
  getMessage: Message;

  constructor(
    private productService: ProductService,
    private route: ActivatedRoute,
    private location: Location,
    private cartService: CartService,
  ) {}

  ngOnInit(): void {
    this.route.paramMap
      .switchMap((params: ParamMap) => this.productService.getProduct(+params.get('id')))
      .subscribe(product => this.product = product);
  }

  save(): void {
    this.productService.update(this.product)
      .then(() => this.goBack());
  }

  goBack(): void {
    this.location.back();
  }

    addToCart(product: Product) : void {
      this.cartService.addProductToCart(product.id).then((message) => { 
        this.getMessage = message;
        if(this.getMessage.message == "FAILURE") {
        alert(product.name + " is already in your cart.");
        } else {
        localStorage.setItem("totalItems", JSON.parse(localStorage.getItem("totalItems")) + 1);
        localStorage.setItem("totalCartAmount", JSON.parse(localStorage.getItem("totalCartAmount")) + product.price);
        alert(product.name + " is added to your cart.");
        location.reload();
        }
    });
  }
}