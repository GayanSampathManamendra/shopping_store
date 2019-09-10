import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-supplier-profile',
  templateUrl: './supplier-profile.component.html',
  styleUrls: ['./supplier-profile.component.scss']
})
export class SupplierProfileComponent implements OnInit {
  public user;

  constructor() { }

  ngOnInit() {
    this.user=(JSON.parse(localStorage.getItem('customer')));
  }

}
