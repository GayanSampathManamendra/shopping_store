import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PreviousCartItemsComponent } from './previous-cart-items.component';

describe('PreviousCartItemsComponent', () => {
  let component: PreviousCartItemsComponent;
  let fixture: ComponentFixture<PreviousCartItemsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PreviousCartItemsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PreviousCartItemsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
