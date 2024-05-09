import { TestBed } from '@angular/core/testing';

import { AdditionDetailsService } from './addition-details.service';

describe('AdditionDetailsService', () => {
  let service: AdditionDetailsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AdditionDetailsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
