import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Injectable({
  providedIn: 'root'
})
export class LoginAndSignupService {

  public base_Url="http://localhost:8080/shoppingApp/api";

  constructor(private http:HttpClient) { }

  form:FormGroup=new FormGroup({
    username:new FormControl('',[Validators.required]),
    email:new FormControl('',[Validators.required]),
    password:new FormControl('',[Validators.required]),
    is_comformed:new FormControl('',[Validators.required]),
    role:new FormControl('',[Validators.required]),
    is_loged:new FormControl('',[Validators.required])
  });

  otp:FormGroup=new FormGroup({
    otpCode:new FormControl('',[Validators.required])
  });

  loginForm:FormGroup=new FormGroup({
    username:new FormControl('',[Validators.required]),
    password:new FormControl('',[Validators.required]),
  });

  registerUser(user:any){
    console.log(user.username);
    return this.http.post(this.base_Url+"/signup",user);
  }

  otpValidation(otp:any){
    console.log(otp);
    return this.http.get(this.base_Url+"/user/loginAndSignup/otp/validation/"+otp);
  }

  loginAuth(user:any){
    console.log(user);
    return this.http.get(this.base_Url+"/login",user);
  }

  setLocalStorageData(user:any){
    localStorage.setItem('customer', JSON.stringify(user));
  }

  getLocalSorageData(){
    const x= JSON.parse(localStorage.getItem('customer'));
    //console.log(x.id);
    return x;
  }
}
