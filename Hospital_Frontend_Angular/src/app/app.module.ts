import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SetDoctorComponent } from './set-doctor/set-doctor.component';
import { SetPatientComponent } from './set-patient/set-patient.component';
import { HomepageComponent } from './homepage/homepage.component';
import { NavbarComponent } from './navbar/navbar.component';
import { DisplayDoctorComponent } from './display-doctor/display-doctor.component';
import { DisplayPatientComponent } from './display-patient/display-patient.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    SetDoctorComponent,
    SetPatientComponent,
    HomepageComponent,
    NavbarComponent,
    DisplayDoctorComponent,
    DisplayPatientComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    BrowserModule,
    FormsModule,
    BrowserModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
