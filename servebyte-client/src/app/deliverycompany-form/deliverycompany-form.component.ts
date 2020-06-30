import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DeliverycompanyServiceService } from '../service/deliverycompany-service.service';
import { Deliverycompany } from '../model/deliverycompany';
 
@Component({
  selector: 'app-deliverycompany-form',
  templateUrl: './deliverycompany-form.component.html',
  styleUrls: ['./deliverycompany-form.component.css']
})
export class DeliverycompanyFormComponent {

  deliveryCompany: Deliverycompany;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private deliveryService: DeliverycompanyServiceService
  ) 
  { 
    this.deliveryCompany = new Deliverycompany;
  }

  onSubmit() {
    this.deliveryService.save(this.deliveryCompany).subscribe(result => {
      this.gotoDeliveryCompanyList();
    })
  }

  gotoDeliveryCompanyList() {
    this.router.navigate(['/delivery-companies']);
  }

}
