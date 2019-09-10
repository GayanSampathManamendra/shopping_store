import { Component, OnInit } from '@angular/core';
import {LoginAndSignupService} from 'src/app/services/login-and-signup.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-supplier-login-and-signup',
  templateUrl: './supplier-login-and-signup.component.html',
  styleUrls: ['./supplier-login-and-signup.component.scss']
})
export class SupplierLoginAndSignupComponent implements OnInit {

  private newUser;
  private customer;

  private username;
  private password;

  private logUser;

  constructor(private service:LoginAndSignupService,
              private _router: Router) { }

  ngOnInit() {
  }

  onSubmit(){
      const user={
        'username':this.service.form.get('username').value,
        'email':this.service.form.get('email').value,
        'password':this.service.form.get('password').value,
        'is_comformed':0,
        'role':2,
        'is_loged':0
      }
      this.service.registerUser(user).subscribe(data=>{
        this.newUser=data;
        console.log(this.newUser);
        if(this.newUser == 1){
          console.log("success !");
          this._router.navigate(['/supplier/loginandsignup/auth']);
          console.log("code ..");
        }
        else{
          console.log("Something went wrong !");
        }
      })
      this.resetForm();

  }

  login(){
    const user={
      'username':this.service.loginForm.get('username').value,
      'password':this.service.loginForm.get('password').value
    }
    this.service.loginAuth(user).subscribe(data=>{
      this.logUser=data;
      //console.log(this.logUser);
    })
  }
  
  resetForm(){
    this.service.form.reset();
  }



}
