import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SupOtpComponent } from './sup-otp.component';

describe('SupOtpComponent', () => {
  let component: SupOtpComponent;
  let fixture: ComponentFixture<SupOtpComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SupOtpComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SupOtpComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
