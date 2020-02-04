import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-componente1',
  templateUrl: './componente1.component.html',
  styleUrls: ['./componente1.component.css']
})
export class Componente1Component implements OnInit {
  public nombre: string="Trujillo";
  constructor() {
    this.nombre = "pepe";
    console.log("Componente 1, de nombre ", this.nombre);
   }

  ngOnInit() {
  }

}
