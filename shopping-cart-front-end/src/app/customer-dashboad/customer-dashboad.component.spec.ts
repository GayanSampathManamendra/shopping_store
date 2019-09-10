import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerDashboadComponent } from './customer-dashboad.component';

describe('CustomerDashboadComponent', () => {
  let component: CustomerDashboadComponent;
  let fixture: ComponentFixture<CustomerDashboadComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CustomerDashboadComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomerDashboadComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
