package com.Highspring.ShoppingCart.service.domain;

import org.springframework.stereotype.Service;

@Service
public interface TaxServiceInterface {
    Double calculateTax();
}
