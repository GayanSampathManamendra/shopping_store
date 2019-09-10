import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.scss']
})
export class NavBarComponent implements OnInit {

  public currentUserId;

  constructor() { }

  ngOnInit() {
    this.currentUserId=(JSON.parse(localStorage.getItem('customer')).id);
    console.log(this.currentUserId);
  }

}
