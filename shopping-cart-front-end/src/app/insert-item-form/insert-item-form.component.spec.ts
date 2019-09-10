import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InsertItemFormComponent } from './insert-item-form.component';

describe('InsertItemFormComponent', () => {
  let component: InsertItemFormComponent;
  let fixture: ComponentFixture<InsertItemFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InsertItemFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InsertItemFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
