import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DeliveryListComponent } from './delivery-list/delivery-list.component';
import { DeliverycompanyFormComponent } from './deliverycompany-form/deliverycompany-form.component'; 

const routes: Routes = [
  { path: 'delivery-companies', component: DeliveryListComponent },
  { path: 'addlogistics', component: DeliverycompanyFormComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
