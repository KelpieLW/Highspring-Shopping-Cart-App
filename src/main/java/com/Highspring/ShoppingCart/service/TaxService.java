package com.Highspring.ShoppingCart.service;

import com.Highspring.ShoppingCart.service.domain.TaxServiceInterface;
import org.springframework.stereotype.Service;

@Service
/**
 * Tax service, made for calculating a default tax rate
 */
public class TaxService implements TaxServiceInterface {
    private final Double DefaultTaxRate=0.085;

    /**
     * Retrieves a tax rate designated as a constant value by the requirements
     * @return {@link Double} with an 8.5% tax rate
     */
    @Override
    public Double calculateTax() {
        return DefaultTaxRate;
    }
}
