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
  setTimeout(() => { this.getProducts(); rahul();}, getRandomInt(1000,6000));
    function rahul() {
      var x = document.getElementById('loader');
      if (x.style.display === 'none') {
          x.style.display = 'block';
      } else {
          x.style.display = 'none';
      }
    }

    function getRandomInt(min, max) {
      min = Math.ceil(min);
      max = Math.floor(max);
      return Math.floor(Math.random() * (max - min)) + min; //The maximum is exclusive and the minimum is inclusive
    }
  }

  getProducts(): void {
    this.productService.getProducts().then(products => this.products = products);
  }
}