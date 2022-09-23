import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SetDoctorComponent } from './set-doctor.component';

describe('SetDoctorComponent', () => {
  let component: SetDoctorComponent;
  let fixture: ComponentFixture<SetDoctorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SetDoctorComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SetDoctorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
