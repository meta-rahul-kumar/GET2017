import { Injectable } from '@angular/core';
import { PRODUCTS} from './mock-product';
import { Product } from './product';

@Injectable()
export class ProductService {
    getProducts(): Product[] {
        return PRODUCTS;
      }
}