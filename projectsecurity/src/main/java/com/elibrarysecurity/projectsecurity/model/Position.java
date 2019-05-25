package com.elibrarysecurity.projectsecurity.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "POSITIONS")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int positionId;

    @NotNull(message = "* Section is required")
    private int section;
    @NotNull(message = "* Line is required")
    private int line;

    @OneToMany(mappedBy = "position", cascade = CascadeType.ALL)
    private List<Book> books = new ArrayList<Book>();


    public Position() {

    }

    public Position(int section, int line) {
        this.section = section;
        this.line = line;
    }


    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public int getSection() {
        return section;
    }

    public void setSection(int section) {
        this.section = section;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}

