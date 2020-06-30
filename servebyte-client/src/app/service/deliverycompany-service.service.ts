import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Deliverycompany } from '../model/deliverycompany';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class DeliverycompanyServiceService {

  private deliveryCompanyUrl: string;

  constructor(private http: HttpClient) { 
    this.deliveryCompanyUrl = 'http://localhost:8030/api/v1/delivery-company'
   }

  public findAll(): Observable<Deliverycompany[]> {
    return this.http.get<Deliverycompany[]>(this.deliveryCompanyUrl);
  }

  public save(deliveryCompany: Deliverycompany) {
    return this.http.post<Deliverycompany>(this.deliveryCompanyUrl, deliveryCompany);
  }
}
