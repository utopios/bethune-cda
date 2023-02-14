import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { HeaderService } from 'src/app/services/header/header.service';
import { TokenStorageService } from 'src/app/services/token-storage/token-storage.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  message: any;
  subscription: Subscription | undefined;

  private roles: string[] = [];
  isLoggedIn = false;

  username?: string;

  showUsersBoard = false;
  showAddEventBoard = false;
  showEventsBoard = false;
  showProfileBoard = false;

  constructor(private tokenStorageService: TokenStorageService, private messageService: HeaderService) {
    this.subscription = this.messageService.getMessage().subscribe((message: any) => {
      this.message = message;
      console.log(this.message);
      if(this.message){
        this.ngOnInit();
      }
    });
  }





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


  ngAfterContentInit() {

    console.log("ngAfterContentInit");
  }

  ngAfterViewInit() {

    console.log("ngAfterViewInit");
  }

  logout(): void {
    this.tokenStorageService.signOut();
    // this.isLoggedIn = false;
    // this.showEventsBoard = false;
    window.location.reload();
  }

}
