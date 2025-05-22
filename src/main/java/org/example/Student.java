package org.example;

import java.util.List;

public class Student {
    private String name;
    private int id;
    private int standard;
    private List<String> books;

    public List<String> getBooks() {
        return books;
    }

    public void setBooks(List<String> books) {
        this.books = books;
    }

    public Student(String name, int id, int standard) {
        this.name = name;
        this.id = id;
        this.standard = standard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStandard() {
        return standard;
    }

    public void setStandard(int standard) {
        this.standard = standard;
    }

    public boolean isSeniorStudent() {
        return standard>5;
    }
}
