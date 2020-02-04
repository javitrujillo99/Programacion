import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { Componente1Component } from './componentes/componente1/componente1.component';
import { Componente2Component } from './componentes/componente2/componente2.component';


const routes: Routes = [
  {path: 'componente1', component:Componente1Component},
  {path: 'componente2', component:Componente2Component},

  //Las comillas significan que la ruta está vacía -> Localhost:4200/
  {path: '', redirectTo: '/componente1', pathMatch: 'full'},

  //Los asteriscos significan que la ruta esta equivocada -> Localhost:4200/coPMonente1
  {path: '**', redirectTo: '/componente1', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
