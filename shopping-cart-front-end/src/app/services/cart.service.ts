import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  public base_Url="http://localhost:8080/shoppingApp/api";

  cartItem:FormGroup=new FormGroup({
    qty:new FormControl('',[Validators.required]),
  });

  constructor(public http:HttpClient) { }

  // get all the cart items which are not paied..
  getCartItems(customer_id:any){
    return this.http.get(this.base_Url+"/show/cart/"+customer_id);
  }

  addItemToCart(item:any){
    console.log(item);
    return this.http.post(this.base_Url+"/item/addToCart",item);
  }

  Payment(payment:any){
    return this.http.post("https://sandbox.payhere.lk/pay/checkout",payment);
  }
}
