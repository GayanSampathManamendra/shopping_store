import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.scss']
})
export class UserProfileComponent implements OnInit {

  public currentUser;

  constructor() { }

  ngOnInit() {
    this.currentUser=(JSON.parse(localStorage.getItem('customer')));

  }

}
