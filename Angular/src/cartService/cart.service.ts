import { Injectable } from '@angular/core';
import { Headers, Http } from '@angular/http';

import 'rxjs/add/operator/toPromise';
import { User } from '../models/user.model';
import { Product } from '../products/product';
import { Message } from '../models/message';
@Injectable()
export class CartService {
    private headers = new Headers({'Content-Type': 'application/json'});
    private cartUrl = 'http://localhost:8080/TechnologyFramework4/service/product';
    constructor(private http: Http) { }

    getCartProducts(): Promise<Product[]> { 
        this.cartUrl = 'http://localhost:8080/TechnologyFramework4/service/product/cartlist';
        return this.http.get(this.cartUrl)
        .toPromise()
        .then(response => response.json() as Product[])
        .catch(this.handleError);
    }

    private handleError(error: any): Promise<any> {
        return Promise.reject(error.message || error);
    }

    removeCartProduct(id: number): Promise<void> {
        this.cartUrl = 'http://localhost:8080/TechnologyFramework4/service/product/remove';
        const url = `${this.cartUrl}/${id}`;    
        return this.http.delete(url, {headers: this.headers})
        .toPromise()
        .then(() => null)
        .catch(this.handleError);
    }

    placeOrder(): Promise<void> {
        this.cartUrl = 'http://localhost:8080/TechnologyFramework4/service/product/cart/placeOrder?email=';
        return this.http.get(`${this.cartUrl}${localStorage.getItem("email")}`, {headers: this.headers})
        .toPromise()
        .catch(this.handleError);
    }

    addProductToCart(productId: number): Promise<Message> {
        this.cartUrl = 'http://localhost:8080/TechnologyFramework4/service/product/cart/addProduct?productId=';
        const url = `${this.cartUrl}${productId}`+ "&user=" + `${localStorage.getItem("email")}`;    
        return this.http
          .post(url, {headers: this.headers})
          .toPromise()
          .then(response => response.json() as Message)
          .catch(this.handleError);
    }
}