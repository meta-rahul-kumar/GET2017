import { Injectable } from '@angular/core';
import { Headers, Http } from '@angular/http';

import 'rxjs/add/operator/toPromise';
import { User } from '../models/user.model';
import { Order } from '../models/order';
import { Product } from '../products/product';
import { Message } from '../models/message';
@Injectable()
export class OrderService {
    private headers = new Headers({'Content-Type': 'application/json'});
    private orderUrl = 'http://localhost:8080/TechnologyFramework4/service/product';
    constructor(private http: Http) { }

    getOrders(): Promise<Order[]> { 
        this.orderUrl = 'http://localhost:8080/TechnologyFramework4/service/product/orderlist?useremail=';
        return this.http.get(this.orderUrl+localStorage.getItem("email"))
        .toPromise()
        .then(response => response.json() as Order[])
        .catch(this.handleError);
    }

    private handleError(error: any): Promise<any> {
        return Promise.reject(error.message || error);
    }

    getOrder(id: number): Promise<Product[]> {
        this.orderUrl= "http://localhost:8080/TechnologyFramework4/service/product/order";
        return this.http.get(this.orderUrl + "/" +id)
          .toPromise()
          .then(response => response.json() as Product[])
          .catch(this.handleError);
      }
}