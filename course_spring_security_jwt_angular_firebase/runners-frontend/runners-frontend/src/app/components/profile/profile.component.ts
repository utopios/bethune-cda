import { Component, OnInit } from '@angular/core';
import {TokenStorageService} from "../../services/token-storage/token-storage.service";
import {User} from "../../models/user";
import {EventService} from "../../services/event-service/event.service";
import {Event} from "../../models/event";
import {Router} from "@angular/router";

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})

/*
This Component gets current User from Storage using TokenStorageService and show information (username, token, email, roles).
This Component will only be shown for users that are moderators to see their events added on this page
 */
export class ProfileComponent implements OnInit {

  currentUser: any;
  events: Event[] = [];


  constructor(private tokenStorageService: TokenStorageService,
              private eventService: EventService,
              private router: Router) { }

  ngOnInit(): void {
    this.currentUser = this.tokenStorageService.getUser();
    console.log(this.currentUser.id);
    this.eventService.getEventsByUserId(this.currentUser.id).subscribe(data => {
      this.events = data;
      console.log(this.events);
    });
  }

  updateEvent(eventId: number) {
    this.router.navigate(["update-event", eventId]);

  }

  deleteEvent(eventId: number) {
    this.eventService.deleteEvent(eventId).subscribe(data => {

      this.ngOnInit();
    })

  }

  navigateToAddEventPage() {
    this.router.navigate(["add-event"])
  }
}
