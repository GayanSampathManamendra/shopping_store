import { Component, OnInit } from '@angular/core';
import {LoginAndSignupService} from 'src/app/services/login-and-signup.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-otp-window',
  templateUrl: './otp-window.component.html',
  styleUrls: ['./otp-window.component.scss']
})
export class OtpWindowComponent implements OnInit {

  public user;
  public otpCode="";

  constructor(private service:LoginAndSignupService,
              private _router:Router) { }

  ngOnInit() {
  }

  onSubmit(){
    const otp_obj={
      'otpCode':this.service.form.get('otpCode').value
    }
    console.log(otp_obj);
 /*   this.service.otpValidation(otp_obj).subscribe(data=>{
      this.user=data;
      console.log(this.user);
      
    })
    this.resetForm();*/

  }

  resetForm(){
    this.service.form.reset();
  }

  cheackOtp(){
    this.service.otpValidation(this.otpCode).subscribe(data=>{
      this.user=data;
      console.log(this.user);
      console.log("ok");
      if(this.user != null){
        localStorage.setItem('customer', JSON.stringify(this.user));
        console.log("user is :"+JSON.parse(localStorage.getItem('customer')));
        const curent_user=this.service.getLocalSorageData();
        console.log(curent_user);
        if(curent_user.role ==1){
          this._router.navigate(['customer/dashboad']);
        }
        if(curent_user.role ==2){
          this._router.navigate(['supplier/dashboad']);
        }
      }
      else{
        console.log("worng otp ! , Try again ..")
      }
    })

  }
  

}
