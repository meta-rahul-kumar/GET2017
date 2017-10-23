import { Component , OnInit} from '@angular/core';
import { UserService } from '../userService/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'navbar',
  templateUrl: './navbar.component.html'
})
export class NavBarComponent implements OnInit{
    cartItems : number;
    totalCartAmount : number;
    constructor(private router: Router) {}
    
    ngOnInit(){
      if (localStorage.getItem("totalItems") == null)
      localStorage.setItem("totalItems", "0");
      this.cartItems = JSON.parse(localStorage.getItem("totalItems"));

      if (localStorage.getItem("totalCartAmount") == null)
      localStorage.setItem("totalCartAmount", "0");
      this.totalCartAmount = JSON.parse(localStorage.getItem("totalCartAmount"));
    }
    logout() : void{
    localStorage.clear();
    this.router.navigate(["/login"]);
    }


}
