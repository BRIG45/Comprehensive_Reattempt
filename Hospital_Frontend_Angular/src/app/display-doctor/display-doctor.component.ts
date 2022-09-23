import { Component, OnInit } from '@angular/core';
import { InfoDoctor } from '../entity/infoDoctor';
import { ServiceHospitalService } from 'src/app/service/service-hospital.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-display-doctor',
  templateUrl: './display-doctor.component.html',
  styleUrls: ['./display-doctor.component.css']
})
export class DisplayDoctorComponent implements OnInit {

  public doctor: InfoDoctor[] = [];
  public errorMessage: string | null = null;
  public name: string | null = null;
  public doc: InfoDoctor = {} as InfoDoctor;
  hidden = true;

  constructor(private activatedRoute: ActivatedRoute, private service: ServiceHospitalService) { }

  ngOnInit(): void {
    this.service.listAllDoctors().subscribe({ 
      next: (data) => {
        this.doctor = data;
      }
    });
  }

  displayDoctorInfo(docId: any) {

    console.log(docId);
    this.service.showDoctor(docId).subscribe({ // this method is called  for getting the  doctor details from backend, and render the information into doctor display page
      next: (data) => {
        console.log(data);
        this.doc = data;
      },
      error: (e) => {
        this.errorMessage = e;
      }
    })

  }

  hidetable() {
    this.hidden = false;

  }

  deleteListedDoc(id: number) {
    alert("Are you want to delete this Doctor");

    this.service.deleteDoctor(id).subscribe(data => { }) // for deleting doctor deatils
    this.hidden = true;
    this.service.listAllDoctors();
  }
}