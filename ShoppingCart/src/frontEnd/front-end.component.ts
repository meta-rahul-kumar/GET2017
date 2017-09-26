import { Component, OnInit } from '@angular/core';
import { Product } from '../products/product';
import { PRODUCTS } from '../products/mock-product';
import { ProductService} from '../products/product.service';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { Location } from '@angular/common';

@Component({
  selector: 'frontend-product-list',
  templateUrl: './front-end.component.html',
  styleUrls: ['./front-end.component.css'],
  providers: [ProductService]
})

export class FrontEndProductListComponent implements OnInit {
  title = 'Products';
  products : Product[];
  selectedProduct: Product;

  onSelect(product: Product): void {
    this.selectedProduct = product;
  }

  constructor(private productService: ProductService,private route: ActivatedRoute,
    private location: Location) { }

  ngOnInit(): void {
    this.getProducts();
  }

  getProducts(): void {
    this.productService.getProducts().then(products => this.products = products);
  }
}