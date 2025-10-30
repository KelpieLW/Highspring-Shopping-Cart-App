package com.Highspring.ShoppingCart.exceptions;

import com.Highspring.ShoppingCart.exceptions.item.*;
import com.Highspring.ShoppingCart.exceptions.order.EmptyOrderException;
import com.Highspring.ShoppingCart.exceptions.taxService.TaxServiceError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity<String> handleItemNotFound(ItemNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(InvalidItemQuantityException.class)
    public ResponseEntity<String> handleInvalidItemQuantity(InvalidItemQuantityException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(InvaliditemPriceException.class)
    public ResponseEntity<String> handleInvalidItemPriceException(InvaliditemPriceException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler (EmptyOrderException.class)
    public ResponseEntity<String> handleEmptyOrderException(EmptyOrderException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler (InvalidItemCategory.class)
    public ResponseEntity<String> handleInvalidItemCatalogue(InvalidItemCategory ex){
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(ex.getMessage());
    }

    @ExceptionHandler (TaxServiceError.class)
    public ResponseEntity<String> handleTaxServiceError(TaxServiceError ex){
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(ex.getMessage());

    }
}
