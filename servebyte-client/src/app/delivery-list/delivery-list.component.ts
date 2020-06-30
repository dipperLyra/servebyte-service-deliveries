import { Component, OnInit } from '@angular/core';
import { Deliverycompany } from '../model/deliverycompany';
import { DeliverycompanyServiceService } from '../service/deliverycompany-service.service';

@Component({
  selector: 'app-delivery-list',
  templateUrl: './delivery-list.component.html',
  styleUrls: ['./delivery-list.component.css']
})
export class DeliveryListComponent implements OnInit {

  deliveryCompanies: Deliverycompany[];

  constructor(private deliveryCompanyService: DeliverycompanyServiceService) { }

  ngOnInit() {
    this.deliveryCompanyService.findAll().subscribe(
      deliveryCompany => {
        this.deliveryCompanies = deliveryCompany;
      });
  }

}
