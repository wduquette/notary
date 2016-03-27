/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wjduquette.notary;

/**
 * Standard note attribute keys.
 * @author will
 */
public enum Key {
    TITLE("Title"),
    BODY("Body"),
    PARENT("Parent");


    private final String name;
    
    Key(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return name;
    }

    /**
     * Retrieve the key's string name.
     * @return A key string.
     */
    public String getName() {
        return name;
    }
}
