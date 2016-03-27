/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wjduquette.notary;

import java.util.HashMap;
import java.util.Map;

/**
 * A Notebook is a collection of notes.  It contains a single root note, 
 * which may contain other notes, and so on.  It also contains the index
 * for looking up notes efficiently.
 * 
 * @author will
 */
public class Notebook {
    private final Note root;
    private int counter;
    private final Map<String,Note> index;
    
    public Notebook() {
        this.counter = 0;
        this.index = new HashMap<>();
        this.root = new Note(this, nextID());
        index.put(root.getID(), root);
    }
    
    // Get the next ID.
    private String nextID() {
        return "N" + counter++;
    }
    
    //-------------------------------------------------------------------------
    // Public Methods
    
    public Note addNote(String parentID) {
        assert index.containsKey(parentID);
        Note note = new Note(this, nextID());
        index.put(note.getID(), note);
        note.set(Key.PARENT, parentID);
        return note;
    }

    /**
     * Get the root note.
     * @return The root note.
     */
    public Note getRoot() {
        return root;
    }
    
    public Note getNote(String id) {
        return index.get(id);
    }
}
