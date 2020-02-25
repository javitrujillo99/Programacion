import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { AngularFireAuth } from '@angular/fire/auth';
import { auth } from 'firebase/app';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-pop-up',
  templateUrl: './pop-up.component.html',
  styleUrls: ['./pop-up.component.css']
})
export class PopUpComponent implements OnInit {

  constructor(
    public dialogRef: MatDialogRef<PopUpComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    public afAuth: AngularFireAuth,
    private router: Router,
    private authService: AuthService
    ) {  }

    public email:string = "";
    public password:string="";

  ngOnInit() {
  }

  closeDialog() {
    this.dialogRef.close();
  }

  onLogin(): void {
    this.authService.loginEmailUser(this.email, this.password)
      .then( (res)=> {
        this.router.navigate(['']);
      }).catch( err => console.log('err', err.message));
  }

  onLogout() {
    this.authService.logoutUser();
  }

}
