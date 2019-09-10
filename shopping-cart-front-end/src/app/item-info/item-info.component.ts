import { Component, OnInit } from '@angular/core';
import {ItemService} from 'src/app/services/item.service';
import {ActivatedRoute,RouterStateSnapshot, Router} from '@angular/router';
import {CartService} from 'src/app/services/cart.service';
import {LoginAndSignupService} from 'src/app/services/login-and-signup.service';


@Component({
  selector: 'app-item-info',
  templateUrl: './item-info.component.html',
  styleUrls: ['./item-info.component.scss']
})
export class ItemInfoComponent implements OnInit {

  public itemInfo;

  public item;
  public bill;
  public currentUser;
  public userId=(JSON.parse(localStorage.getItem('customer')).id);
  public qty;

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
    this.currentUser=(JSON.parse(localStorage.getItem('customer')));
    console.log(this.route.snapshot.params.id);
    console.log(new Date().getTime())
  }

  Submit(){
    console.log("check")
    const cartItem={
      "customer_id":this.currentUser.id,
      "is_payed":0,
      "order_date":new Date().getTime(),
      "order_id":this.route.snapshot.params.id,
      "quentity":this.qty
    }
  //  console.log(cartItem);

   this.service.addItemToCart(cartItem).subscribe(data=>{
      this.item=data;
      console.log(this.item)
    })

   /* this.service.Payment(payment).subscribe(data=>{
      this.bill=data;
      console.log(this.bill);
    })*/
  }

  images = [
    { img: 'https://mdbootstrap.com/img/Photos/Lightbox/Original/img%20(145).jpg', thumb:
    'https://mdbootstrap.com/img/Photos/Lightbox/Original/img%20(145).jpg', description: 'Image 1' },
    { img: 'https://mdbootstrap.com/img/Photos/Lightbox/Original/img%20(150).jpg', thumb:
    'https://mdbootstrap.com/img/Photos/Lightbox/Original/img%20(150).jpg', description: 'Image 2' },
    { img: 'https://mdbootstrap.com/img/Photos/Lightbox/Original/img%20(152).jpg', thumb:
    'https://mdbootstrap.com/img/Photos/Lightbox/Original/img%20(152).jpg', description: 'Image 3' },
    { img: 'https://mdbootstrap.com/img/Photos/Lightbox/Original/img%20(42).jpg', thumb:
    'https://mdbootstrap.com/img/Photos/Lightbox/Original/img%20(42).jpg', description: 'Image 4' },
    { img: 'https://mdbootstrap.com/img/Photos/Lightbox/Original/img%20(151).jpg', thumb:
    'https://mdbootstrap.com/img/Photos/Lightbox/Original/img%20(151).jpg', description: 'Image 5' },
    { img: 'https://mdbootstrap.com/img/Photos/Lightbox/Original/img%20(40).jpg', thumb:
    'https://mdbootstrap.com/img/Photos/Lightbox/Original/img%20(40).jpg', description: 'Image 6' },
    { img: 'https://mdbootstrap.com/img/Photos/Lightbox/Original/img%20(148).jpg', thumb:
    'https://mdbootstrap.com/img/Photos/Lightbox/Original/img%20(148).jpg', description: 'Image 7' },
    { img: 'https://mdbootstrap.com/img/Photos/Lightbox/Original/img%20(147).jpg', thumb:
    'https://mdbootstrap.com/img/Photos/Lightbox/Original/img%20(147).jpg', description: 'Image 8' },
    { img: 'https://mdbootstrap.com/img/Photos/Lightbox/Original/img%20(149).jpg', thumb:
    'https://mdbootstrap.com/img/Photos/Lightbox/Original/img%20(149).jpg', description: 'Image 9' }
  ];

}
