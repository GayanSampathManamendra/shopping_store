import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DashboadHeaderComponent } from './dashboad-header.component';

describe('DashboadHeaderComponent', () => {
  let component: DashboadHeaderComponent;
  let fixture: ComponentFixture<DashboadHeaderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DashboadHeaderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DashboadHeaderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
