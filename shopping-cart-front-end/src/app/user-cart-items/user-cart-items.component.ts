import { Component, OnInit } from '@angular/core';
import {CartService} from 'src/app/services/cart.service';
import {ActivatedRoute,RouterStateSnapshot, Router} from '@angular/router';

@Component({
  selector: 'app-user-cart-items',
  templateUrl: './user-cart-items.component.html',
  styleUrls: ['./user-cart-items.component.scss']
})
export class UserCartItemsComponent implements OnInit {

  private cartItems;

  constructor(private cartService:CartService,
              private router:Router,
              private route:ActivatedRoute) { }

  ngOnInit() {
    this.cartService.getCartItems(this.route.snapshot.params.id).subscribe(data=>{
      this.cartItems=data;
      console.log("cart items !");
      console.log(this.cartItems);
    })
  }

}
