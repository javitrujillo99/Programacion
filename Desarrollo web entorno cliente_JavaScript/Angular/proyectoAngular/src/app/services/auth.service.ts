import { Auth } from './../models/auth';
import { AngularFirestore, DocumentReference } from '@angular/fire/firestore';
import { Injectable } from '@angular/core';
import { AngularFireAuth } from '@angular/fire/auth';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private afsAuth: AngularFireAuth, private db: AngularFirestore) { }

  private authCollectionName = "usuarios";

  saveUser(auth: Auth): Promise<DocumentReference> {
    return this.db.collection(this.authCollectionName).add(auth);
  }
  
  registerUser(auth: Auth) {
    return new Promise ((resolve, reject) => {
      this.afsAuth.auth.createUserWithEmailAndPassword(auth.email, auth.password)
      .then(userData => resolve(userData),
      err => reject(err));
    });
   }
  loginEmailUser(email: string, pass: string) {
    return new Promise((resolve, reject)=>  {
      this.afsAuth.auth.signInWithEmailAndPassword(email, pass)
        .then( userData => resolve(userData),
        err => reject (err));
    });
   }
  logoutUser() {
    return this.afsAuth.auth.signOut();
   }

  isAuth() {
    return this.afsAuth.authState.pipe(map(auth => auth));
  }

}

