import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UnicajaComponent } from './unicaja.component';

describe('UnicajaComponent', () => {
  let component: UnicajaComponent;
  let fixture: ComponentFixture<UnicajaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UnicajaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UnicajaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
