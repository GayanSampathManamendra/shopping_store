import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OtpWindowComponent } from './otp-window.component';

describe('OtpWindowComponent', () => {
  let component: OtpWindowComponent;
  let fixture: ComponentFixture<OtpWindowComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OtpWindowComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OtpWindowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
