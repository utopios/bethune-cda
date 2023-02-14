import { Component, OnInit } from '@angular/core';
import {EventService} from "../../services/event-service/event.service";
import {Event} from "../../models/event";
import {FormControl} from "@angular/forms";
import {debounceTime, distinctUntilChanged, map, Observable, startWith, switchMap} from "rxjs";
import { HeaderService } from 'src/app/services/header/header.service';

@Component({
  selector: 'app-event-list',
  templateUrl: './event-list.component.html',
  styleUrls: ['./event-list.component.css']
})
export class EventListComponent implements OnInit {
  events: Event[] = [];
  cities: string[] = [];
  searchText!: string;
  ifCityExist: boolean = false;

  cityNotFound!: string;
  eventInCityNotExistMessage!: boolean;



  constructor(private eventService: EventService, private headerService: HeaderService ) {}

  ngOnInit(): void {

    this.eventService.getEventCities().subscribe(data => {
      this.cities = data;
      console.log(this.cities);
    })


      this.eventService.getAllEvents().subscribe(data => {
        this.events = data;
        console.log(this.events);
      });
      this.sendMessage();
    }

    sendMessage(): void {
      this.headerService.sendMessage(true);
  }

  searchByCity(searchText: string) {
    this.ifCityExist = true; // we assume that search text is in the cities list
    this.eventInCityNotExistMessage = false; // this error message will only be shown if it's true

    if (searchText.length == 0) { // if we delete something in the search input
      this.eventService.getAllEvents().subscribe(data => {
        this.events = data;
        console.log(this.events);
      });
    }


    else {
      for (let i = 0; i < this.cities.length; i++) {
        if (this.cities[i].toLowerCase() == searchText) { // if the city already exist
          this.ifCityExist = true;
          break;
        } else
          this.ifCityExist = false;
          this.eventInCityNotExistMessage = false;
      }

      if (this.ifCityExist == false) {
        console.log("Events in this city do not exist");
        this.eventInCityNotExistMessage = true;
      } else {
        this.eventService.getAllEventsForCity(searchText).subscribe((data: any) => {
          this.events = data;

        });
      }

    }

  }
}
