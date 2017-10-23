import { Injectable } from '@angular/core';
import { Headers, Http } from '@angular/http';
import { User } from '../models/user.model';
import 'rxjs/add/operator/toPromise';

@Injectable()
export class UserService {

    private headers = new Headers({'Content-Type': 'application/json'});
    private userUrl;
      
    constructor(private http: Http) { }
      
    
check(email: string,password: string): Promise<User> {
    this.userUrl = 'http://localhost:8080/TechnologyFramework4/service/product/login?mailid='; 
    const url = `${this.userUrl}${email}`+"&password="+`${password}`;
    return this.http.get(url)
    .toPromise()
    .then(response => response.json() as User)
    .catch(this.handleError);
    }

    private handleError(error: any): Promise<any> {
        console.error('An error occurred', error); // for demo purposes only
        return Promise.reject(error.message || error);
        }
}