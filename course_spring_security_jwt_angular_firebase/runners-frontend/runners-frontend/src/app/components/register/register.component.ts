import { Component, OnInit } from '@angular/core';
import {AuthService} from "../../services/auth-service/auth.service";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  // this Register component bind from data username, email passowrd from template
  // to register method
  form: any = {
    username: null,
    email: null,
    password: null
  }

  isSuccessful = false;
  errorMessage = '';
  userCanRegisterMessage = '';
  registerButtonDisabled = true;
  isExistingUser = false;


  constructor(private authService: AuthService) { }

  ngOnInit(): void {
  }


  /* Explanation onSubmit() method:
  * // data is the observer that calls the Observable (in this case the observable is http request
  * */
  onSubmit(): void {
    const {username, email, password} = this.form;
    this.authService.checkIfUserExists(username, email, password).subscribe(
      data => {
        console.log(data); // here the data is message 'User Register Successfull' because the Auth Controller on backend return response entity with message user registered succesffuly
        this.registerButtonDisabled = false; // button for register to be enabled
        this.userCanRegisterMessage = data.message; // The data from backend
        this.isExistingUser = false; // user don't exist in database and if it false to show the message that the user can registed successfull
    },
      error => {
        this.errorMessage = error.error.message;
        this.isExistingUser = true; // if the user exist it should show the message that there is already user with existing email or username
        this.registerButtonDisabled = true;
    });
  }

  register(): void {
    const {username, email, password} = this.form;
    this.authService.register(username, email, password).subscribe(
      data => {
        console.log(data); // here the data is message 'User Register Successfull' because the Auth Controller on backend return response entity with message user registered succesffuly
        this.isSuccessful = true;
      },
      error => {
        this.errorMessage = error.error.message;
      });
  }

}
