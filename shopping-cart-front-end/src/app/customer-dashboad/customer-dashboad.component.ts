import { Component, OnInit } from '@angular/core';
import {DashboadService} from 'src/app/services/dashboad.service';

@Component({
  selector: 'app-customer-dashboad',
  templateUrl: './customer-dashboad.component.html',
  styleUrls: ['./customer-dashboad.component.scss']
})
export class CustomerDashboadComponent implements OnInit {


  colorSelect: Array<any>;
  public clothsItems;
  public electronics;
  public educational;
  public selectedOption;

  constructor(private dashboadService:DashboadService){}

  ngOnInit() {
   // console.log(this.selectedOption);
    this.dashboadService.getItems("clothes").subscribe(data=>{
      this.clothsItems=data;
      console.log(this.clothsItems);
    })
    this.dashboadService.getItems("electronics").subscribe(data=>{
      this.electronics=data;
      console.log(this.electronics);
    })
    this.dashboadService.getItems("educational").subscribe(data=>{
      this.educational=data;
      console.log(this.educational);
    })

  }

}
