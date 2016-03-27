/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wjduquette.notary;

import java.util.Properties;

/**
 *
 * @author will
 */
public class Note {
    private Notebook book;
    private String id;
    private Properties attributes;
    
    /**
     * Creates an empty note.  This constructor is used only within the 
     * package; usually, you ask a Notebook to create a new note.
     * @param id The ID of the new note.
     */
    Note(Notebook book, String id) {
        this.book = book;
        this.id = id;
        attributes = new Properties();
        attributes.setProperty(Key.ID.toString(), id);
    }
    
    /**
     * Retrieve the note's unique ID within its notebook.
     * @return The ID.
     */
    public String getID() {
        return id;
    }
    
    /** 
     * Retrieve the value of a note attribute.  Looks up the value in the 
     * current note, and then in its prototypes, and returns the first value
     * found.  Returns null if no value is found.
     * 
     * @param key The attribute name, e.g., "Title"
     * @return The note's value: a string, or null if there is no value.
     */
    public String get(String key) {
        // FIRST, do we have a local value for this key.
        if (attributes.containsKey(key)) {
            return attributes.getProperty(key);
        }
        
        // NEXT, do we have a prototype?  If so, get its value for this key.
//        if (attributes.containsKey(Key.PROTOTYPE)) {
//            Note prototype = book.getNote(attributes.get(Key.PROTOTYPE));
//            assert prototype != null;
//            return prototype.get(key);
//        }
        
        // NEXT, return null.
        return null;
    }
    
    /**
     * Retrieve the value of a note attribute.  Looks up the value in the 
     * current note, and then in its prototypes, and returns the first value
     * found.  Returns null if no value is found.
     * 
     * @param key The standard key.
     * @return The note's value: a string, or null if there is no value.
     */
    public String get(Key key) {
        return get(key.toString());
    }
    
    /**
     * Sets the attribute value.  The value is trimmed.  If the value is null, 
     * the empty string, or any whitespace string, then the local value is
     * cleared (i.e., the attribute is removed from the attributes dictionary.
     * @param key The key
     * @param value The attribute value
     */
    public void set(String key, String value) {
        // FIRST, Handle special cases
        if (Key.ID.toString().equals(key)) {
            throw new IllegalArgumentException("Attempt to change a note's ID.");
        }
        
        if (value == null) {
            attributes.remove(key);
            return;
        }
        
        value = value.trim();
        if (value.isEmpty()) {
            attributes.remove(key);
            return;
        }

        
        attributes.setProperty(key,value);
    }
    
    /**
     * Sets the attribute value.  The value is trimmed.  If the value is null, 
     * the empty string, or any whitespace string, then the local value is
     * cleared (i.e., the attribute is removed from the attributes dictionary.
     * @param key The key
     * @param value The attribute value
     */
    public void set(Key key, String value) {
        set(key.toString(), value);
    }
    
    /**
     * Removes the specified attribute, given its key.
     * @param key The attribute key.
     */
    public void clear(String key) {
        attributes.remove(key);
    }

    /**
     * Removes the specified attribute, given its key.
     * @param key The attribute key.
     */
    public void clear(Key key) {
        set(key, null);
    }
    
    
}
