import { Injectable } from '@angular/core';
import { Subject, Observable } from 'rxjs';




@Injectable({
  providedIn: 'root'
})
export class HeaderService {

  private subject = new Subject();
 
  sendMessage(valeur: boolean) {
      this.subject.next({ valeur: valeur });
  }

  clearMessages() {
      this.subject.next;
  }

  getMessage(): Observable<any> {
      return this.subject.asObservable();
  }
}
