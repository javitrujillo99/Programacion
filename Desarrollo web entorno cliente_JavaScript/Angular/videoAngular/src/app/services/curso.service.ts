import { Injectable } from '@angular/core';
import { AngularFirestore, AngularFirestoreCollection, AngularFirestoreDocument } from 'angularfire2/firestore';
import { CursoInterface } from '../models/cursoInterface';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class CursoService {
  cursosCollection: AngularFirestoreCollection<CursoInterface>;
  cursos: Observable<CursoInterface[]>;
  cursoDoc: AngularFirestoreDocument<CursoInterface>;

  constructor(public afs: AngularFirestore) {
    this.cursos = afs.collection('cursos').valueChanges();
   }


   getCursos() {
     return this.cursos;
   }

   addCurso(curso) {
     console.log("NEW COURSE");
   }

   deleteCurso() {
     console.log("DELETE COURSE");
   }

   updateCurso() {
     console.log("UPDATE COURSE");
   }
}
