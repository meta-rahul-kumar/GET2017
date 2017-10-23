import { Component, OnInit} from '@angular/core';
import { Order } from '../models/order';
import { OrderService} from '../orderService/order.service';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { Location } from '@angular/common';

@Component({
  selector: 'orders',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css'],
  providers: [OrderService]
})

export class OrderComponent implements OnInit{
  orders : Order[];
  selectedOrder: Order;

  ngOnInit(): void{
    this.getOrders(); 
  }

  onSelect(order: Order): void {
    this.selectedOrder = order;
  }

  constructor(private orderService: OrderService,private route: ActivatedRoute,
    private location: Location) { }

  getOrders(): void {
    this.orderService.getOrders().then(orders => this.orders = orders);
  }
}