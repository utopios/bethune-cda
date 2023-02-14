import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";



const API_AUTH = 'http://localhost:8081/api/auth/';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type' : 'application/json'})
} // we add headers into the Http to tell the server what data is returned and
//how to look ad it

@Injectable({
  providedIn: 'root' // this Injectable means that this service
  // can be used in other components and services via constructor
  // which means in the constructor of other components this service
  // should be included
})
export class AuthService {

  constructor(private http:HttpClient) { }

  login(username: string, password: string): Observable<any> {
    return this.http.post(API_AUTH + 'signin' ,{
      username,password},
      httpOptions);
  }

  register(username: string, email: string, password: string): Observable<any> {
    return this.http.post(API_AUTH + 'signup', {
      username, email, password},
      httpOptions);
  }

  checkIfUserExists(username: string, email: string, password: string): Observable<any> {
    return this.http.post(API_AUTH + 'checkIfUserExist', {
        username, email, password},
      httpOptions);
  }


}
