import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { InfoDoctor } from '../entity/infoDoctor';
import { InfoPatient } from '../entity/infoPatient';
import { ServiceHospitalService } from '../service/service-hospital.service';

@Component({
  selector: 'app-set-patient',
  templateUrl: './set-patient.component.html',
  styleUrls: ['./set-patient.component.css']
})
export class SetPatientComponent implements OnInit {

  public patient: InfoPatient = {} as InfoPatient;
  public doctors: InfoDoctor[] = {} as InfoDoctor[];
  public errorMessage: string | null = null;

  constructor(private service: ServiceHospitalService, private router: Router) { }

  ngOnInit(): void {
    this.service.listAllDoctors().subscribe({ // subscribe is a method in angular that connect observer to observable
      next: (data) => {
        this.doctors = data;
      }
    })
  }
  savePatient() {
    this.service.SetPatient(this.patient).subscribe({  // define on the service layer it basically save the patient in to database
      next: (data) => {
        alert("Patient Added to the database")
        this.router.navigate(['/']).then();
      },
      error: (e) => {
        this.errorMessage = e;
        console.warn(e);
        alert("Invalid Information")
        this.router.navigate(['/patients/patient/add']).then();
      }
    });
  }
}

