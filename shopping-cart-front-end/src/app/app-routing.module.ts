import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import {HomeComponent} from 'src/app/home/home.component';
import {LoginandsignupComponent} from 'src/app/loginandsignup/loginandsignup.component';
import {CustomerDashboadComponent} from 'src/app/customer-dashboad/customer-dashboad.component';
import {CategorizedItemsComponent} from  'src/app/categorized-items/categorized-items.component';
import {InsertItemFormComponent} from 'src/app/insert-item-form/insert-item-form.component';
import {UserCartItemsComponent} from 'src/app/user-cart-items/user-cart-items.component';
import {UserProfileComponent} from  'src/app/user-profile/user-profile.component';
import {ItemInfoComponent} from 'src/app/item-info/item-info.component';
import {SupplierLoginAndSignupComponent} from 'src/app/supplier-login-and-signup/supplier-login-and-signup.component';
import {CustomerLoginAndSignupComponent} from 'src/app/customer-login-and-signup/customer-login-and-signup.component';
import {OtpWindowComponent} from 'src/app/otp-window/otp-window.component';
import {SupplierDashboadComponent} from 'src/app/supplier-dashboad/supplier-dashboad.component';
import {SupplierItemShowComponent} from  'src/app/supplier-item-show/supplier-item-show.component';
import {SupplierProfileComponent} from 'src/app/supplier-profile/supplier-profile.component';
import {ItemStockComponent} from 'src/app/item-stock/item-stock.component';
import {RemainingItemsComponent} from 'src/app/remaining-items/remaining-items.component';
import {SupOtpComponent} from 'src/app/sup-otp/sup-otp.component';
import {TestComponent} from 'src/app/test/test.component';

const routes: Routes = [
  {path:'',component:HomeComponent},
  {path:'customer/loginAndSignup',component:CustomerLoginAndSignupComponent},
  {path:'supplier/loginAndSignup',component:SupplierLoginAndSignupComponent},
  {path:'customer/loginandsignup/auth', component:OtpWindowComponent},
  {path:'supplier/dashboad',component:SupplierDashboadComponent},
  {path:'customer/dashboad',component:CustomerDashboadComponent},
  {path:'item/category/:Item_category',component:CategorizedItemsComponent},
  {path:"supplier/register/item",component:InsertItemFormComponent},
  {path:"supplier/itemStock",component:ItemStockComponent},
  {path:"customer/cart/items/:id" ,component:UserCartItemsComponent},
  {path:"user/profile/:id",component:UserProfileComponent},
  {path:"item/info/:id",component:ItemInfoComponent},
  {path:"supplier/item/show/:id",component:SupplierItemShowComponent},
  {path:"supplier/profile",component:SupplierProfileComponent},
  {path:"supplier/itemStock",component:RemainingItemsComponent},
  {path:"supplier/loginandsignup/auth",component:SupOtpComponent},
  {path:"test",component:TestComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
