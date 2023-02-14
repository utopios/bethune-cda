import { Component } from '@angular/core';
import {TokenStorageService} from "./services/token-storage/token-storage.service";


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})


export class AppComponent {

  private roles: string[] = [];
  isLoggedIn = false;

  username?: string;

  showUsersBoard = false;
  showAddEventBoard = false;
  showEventsBoard = false;
  showProfileBoard = false;

  constructor(private tokenStorageService: TokenStorageService) {}

    ngOnInit(): void {
      this.isLoggedIn = this.tokenStorageService.getUser();
      if (this.isLoggedIn) { // what to show on the logged user
      const user = this.tokenStorageService.getUser();
      this.roles = user.roles;
      this.showEventsBoard = true;
      this.showUsersBoard = this.roles.includes('ROLE_ADMIN');
        if (this.roles.includes("ROLE_ADMIN") || this.roles.includes("ROLE_MODERATOR")) {
          this.showAddEventBoard = true;
          this.showProfileBoard = true;

        }
      this.username = user.username;
    }
  }

  logout(): void {
    this.tokenStorageService.signOut();
    // this.isLoggedIn = false;
    // this.showEventsBoard = false;
    window.location.reload();
  }




}
