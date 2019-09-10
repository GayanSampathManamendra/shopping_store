import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SupplierNavBarComponent } from './supplier-nav-bar.component';

describe('SupplierNavBarComponent', () => {
  let component: SupplierNavBarComponent;
  let fixture: ComponentFixture<SupplierNavBarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SupplierNavBarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SupplierNavBarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
