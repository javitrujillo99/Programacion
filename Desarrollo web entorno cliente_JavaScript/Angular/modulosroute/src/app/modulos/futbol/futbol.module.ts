import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { FutbolRoutingModule } from './futbol-routing.module';
import { BarcelonaComponent } from './componentes/barcelona/barcelona.component';
import { RealmadridComponent } from './componentes/realmadrid/realmadrid.component';
import { FutbolcomunComponent } from './componentes/futbolcomun/futbolcomun.component';


@NgModule({
  declarations: [BarcelonaComponent, RealmadridComponent, FutbolcomunComponent],
  imports: [
    CommonModule,
    FutbolRoutingModule
  ]
})
export class FutbolModule { }
