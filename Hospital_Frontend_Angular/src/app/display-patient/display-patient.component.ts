import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { InfoPatient } from '../entity/infoPatient';
import { ServiceHospitalService } from 'src/app/service/service-hospital.service';

@Component({
  selector: 'app-display-patient',
  templateUrl: './display-patient.component.html',
  styleUrls: ['./display-patient.component.css']
})
export class DisplayPatientComponent implements OnInit {
  public id: number | null = null;
  public patient: InfoPatient = {} as InfoPatient;
  public errorMessage: string | null = null;
  hidden = true;
  constructor(private service: ServiceHospitalService, private router: Router) { } // it is basically initialize all the component that required in this component

  ngOnInit(): void {

  }
  displayPatientInfo() {
    if (this.id == null) {

    }
    else if (this.id) {
      this.service.showPatient(this.id).subscribe({ // this method called for getting the Patient details to backend, and render the information into Patient display page
        next: (data) => {
          console.log(data);
          this.patient = data;

        },
        error: (e) => {

          this.errorMessage = "No such patient there in the database";
          alert(this.errorMessage);
        }

      });
    }
  }
  hidetable() {
    this.hidden = false;
  }

  deleteListedPatient(id: any) {
    alert("Are you want to delete this Patient");
    this.service.deletePatient(id).subscribe({ // for deleting Patient details 
      next: (res) => {
        alert("deleted Successfully Done");
        this.hidden = false;
      }
    })
  }
}