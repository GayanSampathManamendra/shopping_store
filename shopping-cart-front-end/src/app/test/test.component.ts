import { Component, OnInit } from '@angular/core';
import {ItemService} from 'src/app/services/item.service';


@Component({
  selector: 'app-test',
  templateUrl: './test.component.html',
  styleUrls: ['./test.component.scss']
})
export class TestComponent implements OnInit {

  public payment_obj;

  constructor(private service:ItemService) { }

  ngOnInit() {
  }

  onSubmit(){
    const payment={
      'merchant_id':'1212553',
      'return_url':'/supplier/dashboad',
      'cancel_url':'/Customer/dashboad',
      'notify_url':'/test',
      'order_id':1,
      'items':'Door bell wireless',
      'currency':'LKR',
      'amount':50,
      'first_name':'Saman',
      'last_name':'kumara',
      'email':'samanp@gmail.com',
      'phone':'0771234567',
      'address':'No.1, Galle Road',
      'city':'Colombo',
      'country':'Sri Lanka'
    }
    
    this.service.pay(payment).subscribe(data=>{
      this.payment_obj=data;
      console.log(this.payment_obj);
    })
  }
  
}
