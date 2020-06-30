import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DeliverycompanyFormComponent } from './deliverycompany-form.component';

describe('DeliverycompanyFormComponent', () => {
  let component: DeliverycompanyFormComponent;
  let fixture: ComponentFixture<DeliverycompanyFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DeliverycompanyFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DeliverycompanyFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
