import { TestBed } from '@angular/core/testing';

import { DeliverycompanyServiceService } from './deliverycompany-service.service';

describe('DeliverycompanyServiceService', () => {
  let service: DeliverycompanyServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DeliverycompanyServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
