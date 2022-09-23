import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SetPatientComponent } from './set-patient.component';

describe('SetPatientComponent', () => {
  let component: SetPatientComponent;
  let fixture: ComponentFixture<SetPatientComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SetPatientComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SetPatientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
