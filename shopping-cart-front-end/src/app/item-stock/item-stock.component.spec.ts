import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ItemStockComponent } from './item-stock.component';

describe('ItemStockComponent', () => {
  let component: ItemStockComponent;
  let fixture: ComponentFixture<ItemStockComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ItemStockComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ItemStockComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
