import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RealmadridComponent } from './realmadrid.component';

describe('RealmadridComponent', () => {
  let component: RealmadridComponent;
  let fixture: ComponentFixture<RealmadridComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RealmadridComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RealmadridComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
