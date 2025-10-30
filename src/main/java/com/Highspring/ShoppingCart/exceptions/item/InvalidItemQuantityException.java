package com.Highspring.ShoppingCart.exceptions.item;

public class InvalidItemQuantityException extends RuntimeException{
    public InvalidItemQuantityException(String message){
        super(message);
    }
}
