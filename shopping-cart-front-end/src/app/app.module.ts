import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule} from '@angular/common/http';
import { RouterModule} from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';

import { AppComponent } from './app.component';

import { AppRoutingModule } from './app-routing.module';
import { MDBBootstrapModule } from 'angular-bootstrap-md';
import { FormsModule } from '@angular/forms';
import { HomeComponent } from './home/home.component';
import {LoginandsignupComponent} from 'src/app/loginandsignup/loginandsignup.component';
import {DashboadHeaderComponent} from 'src/app/dashboad-header/dashboad-header.component';
import {CustomerDashboadComponent} from 'src/app/customer-dashboad/customer-dashboad.component';
import {CategorizedItemsComponent} from  'src/app/categorized-items/categorized-items.component';
import {ItemComponent} from 'src/app/item/item.component';
import {InsertItemFormComponent} from 'src/app/insert-item-form/insert-item-form.component';
import {UserCartItemsComponent} from 'src/app/user-cart-items/user-cart-items.component';
import {PreviousCartItemsComponent} from 'src/app/previous-cart-items/previous-cart-items.component';
import {UserProfileComponent} from 'src/app/user-profile/user-profile.component';
import {ItemInfoComponent} from 'src/app/item-info/item-info.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { CustomerLoginAndSignupComponent } from './customer-login-and-signup/customer-login-and-signup.component';
import { SupplierLoginAndSignupComponent } from './supplier-login-and-signup/supplier-login-and-signup.component';
import { SupplierDashboadComponent } from './supplier-dashboad/supplier-dashboad.component';
import { OtpWindowComponent } from './otp-window/otp-window.component';
import { SupplierProfileComponent } from './supplier-profile/supplier-profile.component';
import { SupplierNavBarComponent } from './supplier-nav-bar/supplier-nav-bar.component';
import { SupplierItemShowComponent } from './supplier-item-show/supplier-item-show.component';
import { ItemStockComponent } from './item-stock/item-stock.component';
import { RemainingItemsComponent } from './remaining-items/remaining-items.component';
import { SupOtpComponent } from './sup-otp/sup-otp.component';
import { TestComponent } from './test/test.component';



// services
//import {DashboadService} from 'src/app/services/dashboad.service';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginandsignupComponent,
    DashboadHeaderComponent,
    CustomerDashboadComponent,
    CategorizedItemsComponent,
    ItemComponent,
    InsertItemFormComponent,
    UserCartItemsComponent,
    PreviousCartItemsComponent,
    UserProfileComponent,
    ItemInfoComponent,
    NavBarComponent,
    CustomerLoginAndSignupComponent,
    SupplierLoginAndSignupComponent,
    SupplierDashboadComponent,
    OtpWindowComponent,
    SupplierProfileComponent,
    SupplierNavBarComponent,
    SupplierItemShowComponent,
    ItemStockComponent,
    RemainingItemsComponent,
    SupOtpComponent,
    TestComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MDBBootstrapModule.forRoot(),
    FormsModule,
    HttpClientModule,
    RouterModule,
    ReactiveFormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
    