import { Component, OnInit } from '@angular/core';
import {ActivatedRoute,RouterStateSnapshot, Router} from '@angular/router';
import {ItemService} from 'src/app/services/item.service';

@Component({
  selector: 'app-previous-cart-items',
  templateUrl: './previous-cart-items.component.html',
  styleUrls: ['./previous-cart-items.component.scss']
})
export class PreviousCartItemsComponent implements OnInit {

  public itemInfo;

  constructor(private router:Router,
              private route:ActivatedRoute,
              private itemService:ItemService) { }

  ngOnInit() {
    this.itemService.getOrderdItems(this.route.snapshot.params.id).subscribe(data=>{
      this.itemInfo=data;
      console.log(this.itemInfo);
    })
  }

}
