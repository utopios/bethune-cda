import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";


const USERS_API_URL = 'http://localhost:8081/users';
const UPDATE_USER_ROLE_API_URL = "http://localhost:8081/add-role-to-user"
@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }


  getAllUsers(): Observable<any> {
    return this.http.get(`${USERS_API_URL}`);
  }

  addModeratorRoleToUser(userId: number): Observable<any> {
    return this.http.put(`${UPDATE_USER_ROLE_API_URL}/${userId}`, userId);
  }

}
