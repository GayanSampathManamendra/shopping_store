import { Component, OnInit } from '@angular/core';
import {ItemService} from 'src/app/services/item.service';
import {ActivatedRoute,RouterStateSnapshot, Router} from '@angular/router';
import {CartService} from 'src/app/services/cart.service';
import {LoginAndSignupService} from 'src/app/services/login-and-signup.service';

@Component({
  selector: 'app-supplier-item-show',
  templateUrl: './supplier-item-show.component.html',
  styleUrls: ['./supplier-item-show.component.scss']
})
export class SupplierItemShowComponent implements OnInit {

  public itemInfo;

  constructor(public itemService:ItemService,
              private router:Router,
              private route:ActivatedRoute,
              private service:CartService,
              private logService:LoginAndSignupService) { }

  ngOnInit() {
    this.itemService.getItem(this.route.snapshot.params.id).subscribe(data=>{
      this.itemInfo=data;
      console.log(this.itemInfo);
    });
  }

}
