import { DocumentReference } from '@angular/fire/firestore';
import { Auth } from './../../../models/auth';
import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { AuthService } from './../../../services/auth.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(private router: Router, private authservice: AuthService) { }
  
  public newUserForm = new FormGroup({
    email: new FormControl('', [Validators.required, Validators.email]),
    password: new FormControl('', Validators.required),
    nombre: new FormControl(''),
    apellidos: new FormControl(''),
    sexo: new FormControl(''),
  })
  ngOnInit() {
  }

  saveUser() {
    if (this.newUserForm.invalid) {
      return;
    }
    let auth: Auth = this.newUserForm.value;
    console.log('email:' + auth.email);
    this.authservice.saveUser(auth)
    .then(response => this.handleSuccessfulSaveUser(response, auth))
    .catch(err => console.error(err));
  }

  handleSuccessfulSaveUser(response: DocumentReference, auth: Auth) {

  }

  onAddUser(form:Auth) {
    console.log('email:' + form.email);
    this.authservice.registerUser(form)
    .then((res) => {
      this.router.navigate(['']);
    }).catch( err => console.log('err', err.message));
  }

}
