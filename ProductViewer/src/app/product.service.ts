import { Injectable } from '@angular/core';
import { PRODUCTS} from './mock-product';
import { Product } from './product';
import { Headers, Http } from '@angular/http';
import 'rxjs/add/operator/toPromise';

@Injectable()
export class ProductService {

    private headers = new Headers({'Content-Type': 'application/json'});
    private productUrl = 'api/products';  // URL to web api
      
    constructor(private http: Http) { }
      
    getProducts(): Promise<Product[]> {
    return this.http.get(this.productUrl)
                .toPromise()
                .then(response => response.json().data as Product[])
                .catch(this.handleError);
    }
      
    private handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
    }
}