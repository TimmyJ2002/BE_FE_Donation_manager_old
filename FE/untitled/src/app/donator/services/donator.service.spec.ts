import { TestBed } from '@angular/core/testing';
import {DonatorService} from "./donator.service";

describe('DonatorServiceService', () => {
  let service: DonatorService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DonatorService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
