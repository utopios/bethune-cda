import {HTTP_INTERCEPTORS, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {TokenStorageService} from "../services/token-storage/token-storage.service";

const TOKEN_HEADER_KEY = 'Authorization'; // for Spring boot backend we are adding Authorization in the header in the request
@Injectable()
export class AuthInterceptor implements HttpInterceptor{

  constructor(private token: TokenStorageService) {}

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    let authReq = req;
    const token = this.token.getToken();
    if (token != null) {
      authReq = req.clone(
        {headers: req.headers.set(TOKEN_HEADER_KEY,'Bearer ' + token)});
    }
    return next.handle(authReq);
  }
}
export const authInterceptorProviders =
  [
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true }
  ];


/*
What is going on in the intercept method ?
takes the current request - gets the token , clones the request because th original request cannot be changed, and also in header it add Authroization attribute
with  Bearer
// next.handle it passes the request to the next interceptor in the list of intercpetor, and the next interceptor is httpclient =- that is going to handle the request
intercept - presretnuvanje go sretnuva requestot pred da se prati na back end
 */
