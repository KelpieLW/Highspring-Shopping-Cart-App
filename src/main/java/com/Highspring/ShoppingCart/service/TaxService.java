package com.Highspring.ShoppingCart.service;

import com.Highspring.ShoppingCart.service.domain.TaxServiceInterface;
import org.springframework.stereotype.Service;

@Service
public class TaxService implements TaxServiceInterface {
    private final Double DefaultTaxRate=0.085;
    @Override
    public Double calculateTax() {
        return DefaultTaxRate;
    }
}
