import { Component, OnInit, ViewChild } from '@angular/core';
import { FormControl, FormGroup, NgForm, Validators } from "@angular/forms";
import { Event } from "../../models/event";
import { MatDatepickerInputEvent } from "@angular/material/datepicker";
import { EventService } from "../../services/event-service/event.service";
import { AngularFireStorage, AngularFireUploadTask } from "@angular/fire/compat/storage";
import { MatSnackBar } from "@angular/material/snack-bar";
import { UploadTaskSnapshot } from "@angular/fire/compat/storage/interfaces";
import { finalize, Observable } from "rxjs";
import { TokenStorageService } from "../../services/token-storage/token-storage.service";
import { Router } from "@angular/router";


@Component({
  selector: 'app-add-event',
  templateUrl: './add-event.component.html',
  styleUrls: ['./add-event.component.css']
})
export class AddEventComponent implements OnInit {

  event = new Event();
  eventPhotoName!: string;
  photo!: File;
  successMessage!: string;
  downloadURL!: Observable<String>
  firebaseUrl!: string;
  currentUser: any;

  // @ts-ignore
  @ViewChild('eventForm') eventForm: NgForm; // here we are getting the reference eventForm in  ts file
  // also try the code without this and see what's going to happen ??


  constructor(private eventService: EventService,
    private angularFireStorage: AngularFireStorage,
    private snackBar: MatSnackBar,
    private tokenStorageService: TokenStorageService,
    private router: Router) { }

  ngOnInit(): void {
    this.currentUser = this.tokenStorageService.getUser();
    this.event.userId = this.currentUser.id;
    console.log(this.event.userId);

  }


  onFileChange(file: any) {
    this.eventPhotoName = file.target.files[0].name;
    this.photo = file.target.files[0];
    //this.uploadImageToFirebase(this.photo); // first we are saving the image in firebase, this is working probably fine
  }

  saveEvent() {
    this.uploadImageToFirebase().then((res:any) => {
      this.eventService.addEvent(this.event.eventName, res, this.event.eventDescription, this.event.eventCity, this.event.eventCountry, this.event.eventDate, this.event.eventRegistrationLink, this.event.userId).subscribe(data => {
        this.successMessage = data.message;
        console.log(this.successMessage)
        this.openSnackBar(this.successMessage);
        this.router.navigate(["profile"])
      });
    })
  }

  uploadImageToFirebase() {
    return new Promise((res, rej) => {
      const fileRef = this.angularFireStorage.ref(this.eventPhotoName);
      const task = this.angularFireStorage.upload(this.eventPhotoName, this.photo);
      task.snapshotChanges().pipe(
        finalize(() => {
          this.downloadURL = fileRef.getDownloadURL();
          res(this.downloadURL)
          // this.eventService.addEventPhotoUrl(this.downloadURL).subscribe(data => {
          //   // @ts-ignore
          //   this.firebaseUrl = data;
          //   console.log(this.firebaseUrl);
          // });
        })).subscribe();
    })
   

  }

  openSnackBar(successMessage: string) {
    this.snackBar.open(successMessage, '', {
      duration: 3000
    });
  }

}

