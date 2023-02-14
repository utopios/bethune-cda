import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { HomeComponent } from './components/home/home.component';
import { ProfileComponent } from './components/profile/profile.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {authInterceptorProviders} from './helpers/auth.interceptor';
import { AddModeratorComponent } from './components/add-moderator/add-moderator.component';
import {MatTableModule} from "@angular/material/table";
import {MatButtonModule} from "@angular/material/button";
import {MatFormFieldModule} from "@angular/material/form-field";
import { MatSnackBarModule } from '@angular/material/snack-bar';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import { AddEventComponent } from './components/add-event/add-event.component';
import {MatInputModule} from "@angular/material/input";
import {MatDatepickerModule} from "@angular/material/datepicker";
import {MatNativeDateModule} from "@angular/material/core";
import {AngularFireStorageModule} from "@angular/fire/compat/storage";
import {AngularFireModule} from "@angular/fire/compat";
import {environment} from "../environments/environment";
import { EventListComponent } from './components/event-list/event-list.component';
import {MatCardModule} from "@angular/material/card";
import { UpdateEventComponent } from './components/update-event/update-event.component';
import {MatCheckboxModule} from "@angular/material/checkbox";
import {MatAutocompleteModule} from "@angular/material/autocomplete";
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { HeaderComponent } from './shared/header/header.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    ProfileComponent,
    AddModeratorComponent,
    AddEventComponent,
    EventListComponent,
    UpdateEventComponent,
    HeaderComponent,
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        FormsModule,
        HttpClientModule,
        BrowserAnimationsModule,
        MatTableModule,
        MatButtonModule,
        MatFormFieldModule,
        MatSnackBarModule,
        ReactiveFormsModule,
        MatInputModule,
        MatDatepickerModule,
        MatNativeDateModule,
        AngularFireModule.initializeApp(environment.firebaseConfig),
        AngularFireStorageModule,
        MatCardModule,
        MatCheckboxModule,
        MatAutocompleteModule,
        Ng2SearchPipeModule

    ],
  providers: [authInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
