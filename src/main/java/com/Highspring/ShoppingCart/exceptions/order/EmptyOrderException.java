package com.Highspring.ShoppingCart.exceptions.order;

public class EmptyOrderException extends RuntimeException{
    public EmptyOrderException(String message){
        super(message);
    }
}

