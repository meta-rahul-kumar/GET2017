import 'rxjs/add/operator/switchMap';
import { Component, OnInit }        from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { Location }                 from '@angular/common';

import { Product }        from '../products/product';
import { ProductService } from '../products/product.service';
import { Router } from '@angular/router';

@Component({
  selector: 'add-product',
  templateUrl: './add-product.component.html',
  styleUrls: [ './add-product.component.css' ]
})
export class AddProductComponent implements OnInit {
  products : Product[];
  selectedProduct: Product;

  constructor(private productService: ProductService,
    private router: Router,private location: Location) { }

  ngOnInit(): void {
    this.getProducts();
  }

  add(id: number,name: string,price: number,quantity: number,rating: number,seller: string,thumbnail: string): void {
    name = name.trim();
    if (!name || !price || !quantity || !rating || !seller || !thumbnail) { return; }
    this.productService.create(id,name,price,quantity,rating,seller,thumbnail)
      .then(product => {
        this.products.push(product);
        Object.keys(this.products).length; 
        this.selectedProduct = null;
        this.location.back();
      });
  }

  onSelect(product: Product): void {
    this.selectedProduct = product;
  }

  getProducts(): void {
    this.productService.getProducts().then(products => this.products = products);
  }

  goBack(): void {
    this.location.back();
  }
}