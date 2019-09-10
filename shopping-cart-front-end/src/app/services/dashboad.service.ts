import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Injectable({
  providedIn: 'root'
})
export class DashboadService {

  public base_Url="http://localhost:8080/shoppingApp/api";

  constructor(private http:HttpClient) { }


  //get  items

  getItems(Item_category:any){
    return this.http.get(this.base_Url+"/items/show/"+Item_category);
  }

  // get items using supplier id..

  getSupplierItems(id:any){
    return this.http.get(this.base_Url+"/show/items/"+id);
  }

}
