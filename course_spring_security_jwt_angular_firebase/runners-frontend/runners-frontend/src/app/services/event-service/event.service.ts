import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Event} from "../../models/event";
import {Observable} from "rxjs";
import {User} from "../../models/user";



const ADD_EVENT_API_URL = "http://localhost:8081/add-event"
const GET_ALL_EVENTS_API_URL = "http://localhost:8081/events"
const GET_EVENT_BY_EVENT_ID_API_URL = "http://localhost:8081/getEvent"
const UPDATE_EVENT_API_URL = "http://localhost:8081/update-event"
const DELETE_EVENT_API_URL = "http://localhost:8081/delete-event"
const GET_EVENT_CITIES_API_URL = "http://localhost:8081/cities"
const GET_EVENT_BY_EVENT_CITY_API_URL = "http://localhost:8081/getAllEventsForCity"

@Injectable({
  providedIn: 'root'
})
export class EventService {

  constructor(private http: HttpClient) { }

  addEvent(eventName: string ,  eventPhotoUrl: string, eventDescription: string, eventCity: string, eventCountry: string, eventDate: Date, eventRegistrationLink: string, userId: number) : Observable<any> {
    const headers = { 'content-type': 'application/json'}
    return this.http.post(`${ADD_EVENT_API_URL}`, {eventName,eventPhotoUrl,eventDescription,eventCity,eventCountry,eventDate,eventRegistrationLink,userId}, {'headers': headers}); // vaka funkcionira
  }

  getAllEvents() : Observable<any> {
    return this.http.get(`${GET_ALL_EVENTS_API_URL}`)
  }

  addEventPhotoUrl(downloadURL: Observable<String>) {
    return downloadURL;
  }

  getEventsByUserId(userId: number): Observable<any> {
    return this.http.get(`${GET_ALL_EVENTS_API_URL}/${userId}`)
    // you don't need body here because you are sending the userId as a PathVariable
  }

  getEventById(eventId: number): Observable<any> {
    return this.http.get(`${GET_EVENT_BY_EVENT_ID_API_URL}/${eventId}`)
  }

  updateEventWithEventPhotoUrl(eventId: number, eventName: string ,  eventPhotoUrl: string, eventDescription: string, eventCity: string, eventCountry: string, eventDate: Date, eventRegistrationLink: string, userId: number) : Observable<any> {
    return this.http.put(`${UPDATE_EVENT_API_URL}/${eventId}`,{eventId,eventName, eventPhotoUrl, eventDescription, eventCity, eventCountry, eventDate, eventRegistrationLink, userId})
  }

  updateEventWithoutEventPhotoUrl(eventId: number, eventName: string, eventDescription: string, eventCity: string, eventCountry: string, eventDate: Date, eventRegistrationLink: string, userId: number) : Observable<any>{
    return this.http.put(`${UPDATE_EVENT_API_URL}/${eventId}`,{eventId,eventName, eventDescription, eventCity, eventCountry, eventDate, eventRegistrationLink, userId})


  }

  deleteEvent(eventId: number) : Observable<any>  {
    return this.http.delete(`${DELETE_EVENT_API_URL}/${eventId}`);
  }

  getEventCities() : Observable<any> {
    return this.http.get(`${GET_EVENT_CITIES_API_URL}`)
  }

  getAllEventsForCity(searchText: string) {
    return this.http.get(`${GET_EVENT_BY_EVENT_CITY_API_URL}/${searchText}`)

  }
}
