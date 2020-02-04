import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BaloncestoModule } from './modulos/baloncesto/baloncesto.module';
import { FutbolModule } from './modulos/futbol/futbol.module';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BaloncestoModule,
    FutbolModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
