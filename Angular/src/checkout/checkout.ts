import { Component, OnInit} from '@angular/core';
import { Product } from '../products/product';
import { PRODUCTS } from '../products/mock-product';
import { CartService} from '../cartService/cart.service';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { Location } from '@angular/common';

@Component({
  selector: 'checkout-component',
  templateUrl: './checkout.html',
  styleUrls: ['./checkout.css'],
  providers: [CartService]
})

export class CheckoutComponent{

    constructor(private cartService: CartService,private route: ActivatedRoute,
        private location: Location) { }

    placeOrder(): void {
        this.cartService
            .placeOrder()
            .then(() => {
            });
            
      }
}