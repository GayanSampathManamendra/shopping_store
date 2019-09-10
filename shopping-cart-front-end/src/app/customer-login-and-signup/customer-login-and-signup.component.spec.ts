import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerLoginAndSignupComponent } from './customer-login-and-signup.component';

describe('CustomerLoginAndSignupComponent', () => {
  let component: CustomerLoginAndSignupComponent;
  let fixture: ComponentFixture<CustomerLoginAndSignupComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CustomerLoginAndSignupComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomerLoginAndSignupComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
