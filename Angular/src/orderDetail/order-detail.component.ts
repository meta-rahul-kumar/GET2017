import 'rxjs/add/operator/switchMap';
import { Component, OnInit }        from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { Location }                 from '@angular/common';

import { Product }        from '../products/product';
import { Order }        from '../models/order';
import { ProductService } from '../products/product.service';
import { OrderService } from '../orderService/order.service';
import { CartService} from '../cartService/cart.service';
import { Message} from '../models/message';

@Component({
  selector: 'order-detail',
  templateUrl: './order-detail.component.html',
  styleUrls: [ './order-detail.component.css' ]
})

export class OrderDetailComponent implements OnInit {
  orderProducts: Product[];
  getMessage: Message;

  constructor(
    private orderService: OrderService,
    private route: ActivatedRoute,
    private location: Location,
    private cartService: CartService,
  ) {}

  ngOnInit(): void {
    this.route.paramMap
      .switchMap((params: ParamMap) => this.orderService.getOrder(+params.get('id')))
      .subscribe(products => this.orderProducts = products);
  }

  goBack(): void {
    this.location.back();
  }

}