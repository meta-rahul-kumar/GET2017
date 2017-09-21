import { Component, OnInit } from '@angular/core';
import { Product } from './product';
import { PRODUCTS } from './mock-product';
import { ProductService} from './product.service'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [ProductService]
})

export class AppComponent {
  title = 'Products';
  products : Product[];
  selectedProduct: Product;

  onSelect(product: Product): void {
    this.selectedProduct = product;
  }

  constructor(private productService: ProductService) { }

  ngOnInit(): void {
    this.getProducts();
  }

  getProducts(): void {
    this.products = this.productService.getProducts();
  }
}

