import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { BaloncestoRoutingModule } from './baloncesto-routing.module';
import { EstudiantesComponent } from './componentes/estudiantes/estudiantes.component';
import { UnicajaComponent } from './componentes/unicaja/unicaja.component';
import { BaloncestocomunComponent } from './componentes/baloncestocomun/baloncestocomun.component';


@NgModule({
  declarations: [EstudiantesComponent, UnicajaComponent, BaloncestocomunComponent],
  imports: [
    CommonModule,
    BaloncestoRoutingModule
  ]
})
export class BaloncestoModule { }
