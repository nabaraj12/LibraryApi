package com.example.Books;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "genre")
public class Genre {

    @Id
    int id;
    String name;


    public Genre()
    {

    }
    public Genre(int id, String genreName) {
        this.id = id;
        this.name = genreName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
