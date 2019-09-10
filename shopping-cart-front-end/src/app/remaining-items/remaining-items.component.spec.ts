import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RemainingItemsComponent } from './remaining-items.component';

describe('RemainingItemsComponent', () => {
  let component: RemainingItemsComponent;
  let fixture: ComponentFixture<RemainingItemsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RemainingItemsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RemainingItemsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
