import { Component, OnInit } from '@angular/core';
import {ItemService} from 'src/app/services/item.service';

@Component({
  selector: 'app-insert-item-form',
  templateUrl: './insert-item-form.component.html',
  styleUrls: ['./insert-item-form.component.scss']
})
export class InsertItemFormComponent implements OnInit {

  public items;

  constructor(private service:ItemService) { }

  ngOnInit() {
  }

  onSubmit(){
    console.log("check");
    const item={
      'item_name':this.service.Item.get('item_name').value,
      'brand':this.service.Item.get('brand').value,
      'stock':this.service.Item.get('stock').value,
      'price':this.service.Item.get('price').value,
      'item_category':this.service.Item.get('item_category').value,
      'description':this.service.Item.get('description').value,
      'suplier_id':(JSON.parse(localStorage.getItem('supplier')).id)
    }
    this.service.registerItem(item).subscribe(data=>{
      this.items=data;
      console.log(this.items);
    })
    this.resetForm();
    
  }

  resetForm(){
    this.service.Item.reset();
  }

}
