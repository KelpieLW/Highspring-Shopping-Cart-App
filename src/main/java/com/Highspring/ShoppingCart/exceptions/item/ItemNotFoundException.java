package com.Highspring.ShoppingCart.exceptions.item;

public class ItemNotFoundException extends RuntimeException{
    public ItemNotFoundException(String message){
        super(message);
    }
}

