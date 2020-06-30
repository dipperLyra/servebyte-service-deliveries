import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { DeliveryListComponent } from './delivery-list/delivery-list.component';
import { DeliverycompanyFormComponent } from './deliverycompany-form/deliverycompany-form.component';
import { DeliverycompanyServiceService } from './service/deliverycompany-service.service';

@NgModule({
  declarations: [
    AppComponent,
    DeliveryListComponent,
    DeliverycompanyFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [DeliverycompanyServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
