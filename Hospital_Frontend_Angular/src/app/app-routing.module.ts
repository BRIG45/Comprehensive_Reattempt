import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SetDoctorComponent } from './set-doctor/set-doctor.component';
import { SetPatientComponent } from './set-patient/set-patient.component';
import { HomepageComponent } from './homepage/homepage.component';
import { DisplayDoctorComponent } from './display-doctor/display-doctor.component';
import { DisplayPatientComponent } from './display-patient/display-patient.component';

const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'doctors/doctor/add', component: SetDoctorComponent },
  { path: 'doctor/view', component: DisplayDoctorComponent },
  { path: 'patients/patient/add', component: SetPatientComponent },
  { path: 'patient/view', component: DisplayPatientComponent },
  { path: '**', component: HomepageComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
