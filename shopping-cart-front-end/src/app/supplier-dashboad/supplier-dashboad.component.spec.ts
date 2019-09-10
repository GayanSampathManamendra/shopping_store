import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SupplierDashboadComponent } from './supplier-dashboad.component';

describe('SupplierDashboadComponent', () => {
  let component: SupplierDashboadComponent;
  let fixture: ComponentFixture<SupplierDashboadComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SupplierDashboadComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SupplierDashboadComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
