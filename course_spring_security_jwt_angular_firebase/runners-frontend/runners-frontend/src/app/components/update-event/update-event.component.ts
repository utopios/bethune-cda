import {Component, OnInit, ViewChild} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {EventService} from "../../services/event-service/event.service";
import {Event} from "../../models/event";
import {finalize, Observable} from "rxjs";
import {AngularFireStorage} from "@angular/fire/compat/storage";
import {MatSnackBar} from "@angular/material/snack-bar";
import {TokenStorageService} from "../../services/token-storage/token-storage.service";
import {NgForm} from "@angular/forms";

@Component({
  selector: 'app-update-event',
  templateUrl: './update-event.component.html',
  styleUrls: ['./update-event.component.css']
})
export class UpdateEventComponent implements OnInit {

  event! : Event;
  eventIdFromRoute! : number;
  eventPhotoName! : string;
  photo! : File;
  successMessage!: string;
  downloadURL! : Observable<String>
  firebaseUrl! : string;
  showChangeEventPhotoInput = false;

  // @ts-ignore
  @ViewChild('eventForm') eventForm: NgForm;

  constructor(private route: ActivatedRoute,
              private eventService: EventService,
              private angularFireStorage : AngularFireStorage,
              private snackBar: MatSnackBar,
              private tokenStorageService: TokenStorageService,
              private router: Router) { }

  ngOnInit(): void {
    this.event = new Event();
    this.eventIdFromRoute = Number(this.route.snapshot.paramMap.get('eventId'));
    console.log(this.eventIdFromRoute);
    this.eventService.getEventById(this.eventIdFromRoute).subscribe(data => {
      this.event = data; // here you are making the initialization of the event
      console.log(this.event);
    });

  }

  onFileChange(file: any) {
    this.eventPhotoName = file.target.files[0].name;
    this.photo = file.target.files[0];
    this.uploadImageToFirebase(this.photo); // first we are saving the image in firebase, this is working probably fine
  }

  uploadImageToFirebase(photo: File) {
    const fileRef = this.angularFireStorage.ref(this.eventPhotoName);
    const task = this.angularFireStorage.upload(this.eventPhotoName, photo);
    task.snapshotChanges().pipe(
      finalize(() => {
        this.downloadURL = fileRef.getDownloadURL();
        this.eventService.addEventPhotoUrl(this.downloadURL).subscribe(data => {
          // @ts-ignore
          this.firebaseUrl = data;
        });
      })).subscribe();

  }

  updateEvent() {
    console.log(this.event.eventPhotoUrl);
    if (this.firebaseUrl) {
      this.eventService.updateEventWithEventPhotoUrl(this.event.eventId,this.event.eventName,  this.firebaseUrl, this.event.eventDescription, this.event.eventCity, this.event.eventCountry, this.event.eventDate, this.event.eventRegistrationLink, this.event.userId).subscribe(data => {
        this.successMessage = data.message;
        console.log(this.successMessage)
        this.openSnackBar(this.successMessage);
        this.router.navigate(["profile"])
      });
    } else {
      // update everything except event photo url
      this.eventService.updateEventWithoutEventPhotoUrl(this.event.eventId,this.event.eventName, this.event.eventDescription, this.event.eventCity, this.event.eventCountry, this.event.eventDate, this.event.eventRegistrationLink, this.event.userId).subscribe(data => {
        this.successMessage = data.message;
        console.log(this.successMessage)
        this.openSnackBar(this.successMessage);
        this.router.navigate(["profile"])
      });
    }

  }

  openSnackBar(successMessage: string) {
    this.snackBar.open(successMessage, '',{
      duration: 3000
    });
  }

  toggleEditable(event: any) {
    if (event.target.checked) {
      this.showChangeEventPhotoInput = true
    } else {
      this.showChangeEventPhotoInput = false;
    }
}
}
