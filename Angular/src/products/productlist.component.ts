import { Component, OnInit } from '@angular/core';
import { Product } from './product';
import { PRODUCTS } from './mock-product';
import { ProductService} from './product.service'
import { Router } from '@angular/router';
import {ProductSearchComponent} from '../productSearch/product-search.component';

@Component({
  selector: 'product-list',
  templateUrl: './productlist.component.html',
  styleUrls: ['./productlist.component.css'],
  providers: [ProductService]
})

export class ProductListComponent implements OnInit {
  title = 'Products';
  products : Product[];
  selectedProduct: Product;

  onSelect(product: Product): void {
    this.selectedProduct = product;
  }

  constructor(private productService: ProductService,
    private router: Router) { }

  ngOnInit(): void {
    this.getProducts();
  }

  getProducts(): void {
    this.productService.getProducts().then(products => this.products = products);
  }

  delete(product: Product): void {
    this.productService
        .delete(product.id)
        .then(() => {
          this.products = this.products.filter(h => h !== product);
          if (this.selectedProduct === product) { this.selectedProduct = null; }
        });
  }

  gotoDetail(): void {
    this.router.navigate(['/detail', this.selectedProduct.id]);
  }

  add(id: number,name: string,price: number,quantity: number,rating: number,seller: string,thumbnail: string): void {
    name = name.trim();
    if (!name) { return; }
    this.productService.create(id,name,price,quantity,rating,seller,thumbnail)
      .then(product => {
        this.products.push(product);
        this.selectedProduct = null;
      });
  }
}

