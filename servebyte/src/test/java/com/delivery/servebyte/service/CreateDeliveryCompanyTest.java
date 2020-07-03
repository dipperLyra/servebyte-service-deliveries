package com.delivery.servebyte.service;

import com.delivery.servebyte.persistence.repositories.DeliveryCompanyRepository;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class CreateDeliveryCompanyTest {

    @MockBean
    DeliveryCompanyRepository deliveryCompanyRepository;
}
