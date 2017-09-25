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

    delete(id: number): Promise<void> {
        const url = `${this.productUrl}/${id}`;
        return this.http.delete(url, {headers: this.headers})
            .toPromise()
            .then(() => null)
            .catch(this.handleError);
    }

    update(product: Product): Promise<Product> {
        const url = `${this.productUrl}/${product.id}`;
        return this.http
          .put(url, JSON.stringify(product), {headers: this.headers})
          .toPromise()
          .then(() => product)
          .catch(this.handleError);
      }

      getProduct(id: number): Promise<Product> {
        const url = `${this.productUrl}/${id}`;
        return this.http.get(url)
          .toPromise()
          .then(response => response.json().data as Product)
          .catch(this.handleError);
      }


      create(id: number,name: string,price: number,quantity: number,rating: number,seller: string,thumbnail: string): Promise<Product> {
        return this.http
          .post(this.productUrl, JSON.stringify({id: id,name: name,price: price,quantity: quantity,rating: rating,seller: seller,thumbnail: thumbnail}), {headers: this.headers})
          .toPromise()
          .then(res => res.json().data as Product)
          .catch(this.handleError);
      }
      
      private handleError(error: any): Promise<any> {
        console.error('An error occurred', error); // for demo purposes only
        return Promise.reject(error.message || error);
        }
}