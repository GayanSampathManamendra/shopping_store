import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CategorizedItemsComponent } from './categorized-items.component';

describe('CategorizedItemsComponent', () => {
  let component: CategorizedItemsComponent;
  let fixture: ComponentFixture<CategorizedItemsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CategorizedItemsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CategorizedItemsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
