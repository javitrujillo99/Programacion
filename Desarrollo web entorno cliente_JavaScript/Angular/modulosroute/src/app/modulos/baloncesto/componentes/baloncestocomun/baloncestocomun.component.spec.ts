import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BaloncestocomunComponent } from './baloncestocomun.component';

describe('BaloncestocomunComponent', () => {
  let component: BaloncestocomunComponent;
  let fixture: ComponentFixture<BaloncestocomunComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BaloncestocomunComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BaloncestocomunComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
