import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FutbolcomunComponent } from './futbolcomun.component';

describe('FutbolcomunComponent', () => {
  let component: FutbolcomunComponent;
  let fixture: ComponentFixture<FutbolcomunComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FutbolcomunComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FutbolcomunComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
