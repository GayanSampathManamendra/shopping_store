import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SupplierItemShowComponent } from './supplier-item-show.component';

describe('SupplierItemShowComponent', () => {
  let component: SupplierItemShowComponent;
  let fixture: ComponentFixture<SupplierItemShowComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SupplierItemShowComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SupplierItemShowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
