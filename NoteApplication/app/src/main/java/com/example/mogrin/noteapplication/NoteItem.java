package com.example.mogrin.noteapplication;

public class NoteItem {
    String name;
    NoteAdapter parent;

    NoteItem(String name, NoteAdapter parent){
        this.name = name;
        this.parent = parent;
    }
}
