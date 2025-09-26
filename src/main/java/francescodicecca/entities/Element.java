package francescodicecca.entities;

import javax.persistence.*;
import javax.swing.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Element {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "publication_at")
    private int publication_at;

    public Element() {}

    public Element(String title, int publication_at) {
        this.title = title;
        this.publication_at = publication_at;
    }

    public Long getId() { return id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public int getPublication_at() { return publication_at; }
    public void setPublication_at(int publication_at) { this.publication_at = publication_at; }

    @Override
    public String toString() {
        return "ID: " + id + '\n' +
                "Title: " + title + '\n' +
                "Publication: " + publication_at + '\n';
    }
}
