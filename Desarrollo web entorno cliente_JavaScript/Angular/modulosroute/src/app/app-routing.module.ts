import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FutbolcomunComponent } from './modulos/futbol/componentes/futbolcomun/futbolcomun.component';
import { BaloncestocomunComponent } from './modulos/baloncesto/componentes/baloncestocomun/baloncestocomun.component';


const routes: Routes = [
  {path: '/futbol' , component: FutbolcomunComponent},
  {path: '/baloncesto' , component: BaloncestocomunComponent},
  {path: '', redirectTo: '/futbol'},
  {path: '**', redirectTo: '/futbol'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
