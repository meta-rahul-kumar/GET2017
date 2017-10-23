import { Component , OnInit} from '@angular/core';
import { UserService } from '../userService/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'login',
  templateUrl: './login.component.html'
})
export class LoginComponent {
    constructor(private userService: UserService,private router: Router) { }

    ngOnInit(){
        if (localStorage.getItem("email") != null){
            this.router.navigate(["/dashboard"]);
        }
    }

    checkAuth(email: string,password: string): void {
        if (!email || !password) { return; }
        this.userService.check(email,password)
          .then(user => {
            if(user == null) {
                this.router.navigate(["/login"]);
            } else {
                localStorage.setItem("email",user.email);
                this.router.navigate(["/dashboard"]);
            }
          });
      }
}
