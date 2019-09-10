import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SupplierLoginAndSignupComponent } from './supplier-login-and-signup.component';

describe('SupplierLoginAndSignupComponent', () => {
  let component: SupplierLoginAndSignupComponent;
  let fixture: ComponentFixture<SupplierLoginAndSignupComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SupplierLoginAndSignupComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SupplierLoginAndSignupComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
