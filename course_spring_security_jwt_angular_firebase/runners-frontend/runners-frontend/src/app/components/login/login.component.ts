import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from "../../services/auth-service/auth.service";
import { TokenStorageService } from "../../services/token-storage/token-storage.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  form: any = {
    username: null,
    password: null
  };

  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
  roles: string[] = [];



  constructor(private authService: AuthService,
    private tokenStorageService: TokenStorageService, private router: Router) {
  }

  ngOnInit(): void {
    if (this.tokenStorageService.getToken()) {
      this.isLoggedIn = true;
      this.roles = this.tokenStorageService.getUser().roles;
      // if the user is logged in then it should take all the roles that are there
    }
  }

  onSubmit(): void {
    const { username, password } = this.form;
    this.authService.login(username, password).subscribe(
      data => {
        // data is the value that is return by Observable
        console.log(data);
        this.tokenStorageService.saveToken(data.accessToken); // to save the token in Session
        this.tokenStorageService.saveUser(data);
        this.isLoginFailed = false;
        this.isLoggedIn = true;
        this.roles = this.tokenStorageService.getUser().roles;
       //this.reloadPage();
       setTimeout(() => {
        this.router.navigate(['/events'])
      }, 2000);
      },
      error => {
        this.errorMessage = error.error.message;
        this.isLoginFailed = true;

      }
    )
   
  }




  reloadPage(): void {
    window.location.reload();
    
  }
}
