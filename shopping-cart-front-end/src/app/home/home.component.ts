import { Component, OnInit } from '@angular/core';
import { FormControl, Validators, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  validatingForm: FormGroup;

  ngOnInit() {
    this.validatingForm = new FormGroup({
      modalFormDarkEmail: new FormControl('', Validators.email),
      modalFormDarkPassword: new FormControl('', Validators.required)
    });
  }

  get modalFormDarkEmail() {
    return this.validatingForm.get('modalFormDarkEmail');
  }

  get modalFormDarkPassword() {
    return this.validatingForm.get('modalFormDarkPassword');
  }
}
