import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UnicajaComponent } from './componentes/unicaja/unicaja.component';
import { EstudiantesComponent } from './componentes/estudiantes/estudiantes.component';


const routes: Routes = [
  {path: '', redirectTo: '/baloncestocomun', pathMatch: 'full'},
  {path: '**', redirectTo: '/baloncestocomun', pathMatch: 'full'},
  {children: [
    {path: 'unicaja', component: UnicajaComponent},
    {path: 'unicaja', component: EstudiantesComponent}
  ]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BaloncestoRoutingModule { }
