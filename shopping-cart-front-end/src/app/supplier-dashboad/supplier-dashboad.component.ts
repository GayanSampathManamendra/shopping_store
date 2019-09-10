import { Component, OnInit } from '@angular/core';
import {DashboadService} from  'src/app/services/dashboad.service';

@Component({
  selector: 'app-supplier-dashboad',
  templateUrl: './supplier-dashboad.component.html',
  styleUrls: ['./supplier-dashboad.component.scss']
})
export class SupplierDashboadComponent implements OnInit {

  public supId;
  public items;

  constructor(private dashboadService:DashboadService) { }

  ngOnInit() {
    this.supId=(JSON.parse(localStorage.getItem('supplier')).id)
    
    this.dashboadService.getSupplierItems(this.supId).subscribe(data=>{
        this.items=data;
        console.log(this.supId);
        console.log(this.items);
    })
  }

}
