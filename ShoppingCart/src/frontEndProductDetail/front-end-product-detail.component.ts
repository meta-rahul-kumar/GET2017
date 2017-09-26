import 'rxjs/add/operator/switchMap';
import { Component, OnInit }        from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { Location }                 from '@angular/common';

import { Product }        from '../products/product';
import { ProductService } from '../products/product.service';

@Component({
  selector: 'front-end-product-detail',
  templateUrl: './front-end-product-detail.component.html',
  styleUrls: [ './front-end-product-detail.component.css' ]
})

export class FrontEndProductDetailComponent implements OnInit {
  product: Product;

  constructor(
    private productService: ProductService,
    private route: ActivatedRoute,
    private location: Location
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
}