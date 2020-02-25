import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { AuthService } from './../../../services/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(private router: Router, private authservice: AuthService) { }
  public email: string = "";
  public password: string="";
  ngOnInit() {
  }

  onAddUser() {
    this.authservice.registerUser(this.email, this.password)
    .then((res) => {
      this.router.navigate(['']);
    }).catch( err => console.log('err', err.message));
  }

}
