import { TestBed } from '@angular/core/testing';

import { ServiceHospitalService } from './service-hospital.service';

describe('ServiceHospitalService', () => {
  let service: ServiceHospitalService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ServiceHospitalService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
