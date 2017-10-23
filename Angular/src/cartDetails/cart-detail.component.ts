import { Component, OnInit} from '@angular/core';
import { Product } from '../products/product';
import { PRODUCTS } from '../products/mock-product';
import { CartService} from '../cartService/cart.service';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { Location } from '@angular/common';

@Component({
  selector: 'cart-detail',
  templateUrl: './cart-detail.component.html',
  styleUrls: ['./cart-detail.component.css'],
  providers: [CartService]
})

export class CartDetailComponent implements OnInit{
  cartProducts : Product[];

  ngOnInit(): void{
    this.getCartProducts(); 
  }
  constructor(private cartService: CartService,private route: ActivatedRoute,
    private location: Location) { }

  getCartProducts(): void {
    this.cartService.getCartProducts().then(cartProducts => this.cartProducts = cartProducts);
  }

  removeItemFromCart(product: Product): void {
    this.cartService
        .removeCartProduct(product.id)
        .then(() => {
          this.cartProducts = this.cartProducts.filter(h => h !== product);
        });
        localStorage.setItem("totalItems", JSON.stringify(JSON.parse(localStorage.getItem("totalItems")) - 1));
        localStorage.setItem("totalCartAmount", JSON.stringify(JSON.parse(localStorage.getItem("totalCartAmount")) - product.price));
        location.reload();
   }
}