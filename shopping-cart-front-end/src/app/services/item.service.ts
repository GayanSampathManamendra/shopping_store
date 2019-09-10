import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Injectable({
  providedIn: 'root'
})
export class ItemService {

  public base_Url="http://localhost:8080/shoppingApp/api";

  Item:FormGroup=new FormGroup({
    item_name:new FormControl('',[Validators.required]),
    brand:new FormControl('',[Validators.required]),
    stock:new FormControl('',[Validators.required]),
    price:new FormControl('',[Validators.required]),
    item_category:new FormControl('',[Validators.required]),
    description:new FormControl('',[Validators.required]),
    suplier_id:new FormControl('',[Validators.required])
    
  });

  payment:FormGroup=new FormGroup({
    merchant_id:new FormControl('',[Validators.required]),
    return_url:new FormControl('',[Validators.required]),
    cancel_url:new FormControl('',[Validators.required]),
    notify_url:new FormControl('',[Validators.required]),
    order_id:new FormControl('',[Validators.required]),
    items:new FormControl('',[Validators.required]),
    currency:new FormControl('',[Validators.required]),
    amount:new FormControl('',[Validators.required]),
    first_name:new FormControl('',[Validators.required]),
    last_name:new FormControl('',[Validators.required]),
    email:new FormControl('',[Validators.required]),
    phone:new FormControl('',[Validators.required]),
    address:new FormControl('',[Validators.required]),
    city:new FormControl('',[Validators.required]),
    country:new FormControl('',[Validators.required])
    
  });

  constructor(private http:HttpClient) { }

  // get the selected item
  getItem(id:any){
    return this.http.get(this.base_Url+"/item/show/"+id);
  }

  // get all the items of particular customer..
  getOrderdItems(customer_id:any){
    return this.http.get(this.base_Url+"/show/items/"+customer_id);

  }

  registerItem(item:any){
    //console.log(item);
    return this.http.post(this.base_Url+"/item/register",item);
  }

  pay(payment:any){
    console.log(payment);
    return this.http.post("//sandbox.payhere.lk/pay/checkout",payment);
  }

  // get the all the items of particular supplier..

  
 
}
