import { Injectable } from '@angular/core';

// TokenStorageService get the user token & user information from
/* Browser Session Storage. FOr logout we only need to clear this Session Storage
We save the user ifnormation and token in the Session in browser
* */

const TOKEN_KEY = 'auth-token';
const USER_KEY = 'auth-user';
@Injectable({
  providedIn: 'root'
})
export class TokenStorageService {

  constructor() { }

  signOut(): void {
    window.sessionStorage.clear(); // clearing all the information about the user
  }

  public saveToken(token: string): void {
    window.sessionStorage.removeItem(TOKEN_KEY); // to remove the previous token in the session
    window.sessionStorage.setItem(TOKEN_KEY,token); // to add new token in the session
    // in the session we will add attribute with name auth-token, and the
    // value for that authe token will be the token that we'll be generated from backend
  }

  public getToken(): string | null {
    return window.sessionStorage.getItem(TOKEN_KEY);
  }

  public saveUser(user: any): void {
    window.sessionStorage.removeItem(USER_KEY);
    window.sessionStorage.setItem(USER_KEY,JSON.stringify(user))
  }

  public getUser(): any {
    const user = window.sessionStorage.getItem(USER_KEY);
    if (user) {
      return JSON.parse(user);
    }
    // return {};
    else {
      return false;
    }
  }



}
