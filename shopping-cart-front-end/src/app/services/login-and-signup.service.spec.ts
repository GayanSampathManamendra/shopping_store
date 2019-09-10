import { TestBed } from '@angular/core/testing';

import { LoginAndSignupService } from './login-and-signup.service';

describe('LoginAndSignupService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: LoginAndSignupService = TestBed.get(LoginAndSignupService);
    expect(service).toBeTruthy();
  });
});
