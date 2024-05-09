import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdditionDetailsComponent } from './addition-details.component';

describe('AdditionDetailsComponent', () => {
  let component: AdditionDetailsComponent;
  let fixture: ComponentFixture<AdditionDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdditionDetailsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdditionDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
