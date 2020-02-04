import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { Modulo1Module } from './modulos/modulo1/modulo1.module';
import { Modulo2Module } from './modulos/modulo2/modulo2.module';
import { Componente1Component } from './componentes/componente1/componente1.component';
import { Componente2Component } from './componentes/componente2/componente2.component';

@NgModule({
  declarations: [
    AppComponent,
    Componente1Component,
    Componente2Component
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    Modulo1Module,
    Modulo2Module
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
