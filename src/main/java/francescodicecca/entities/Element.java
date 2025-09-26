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

    @Column(name = "isbn", nullable = false, unique = true)
    private String isbn;

    @Column(name = "title")
    private String title;

    @Column(name = "publication_at")
    private int publication_at;

    @Column(name = "pages")
    private int pages;

    public Element() {}

    public Element(String isbn, String title, int publication_at, int pages) {
        this.isbn = isbn;
        this.title = title;
        this.publication_at = publication_at;
        this.pages = pages;
    }

    public Long getId() { return id; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public int getPublication_at() { return publication_at; }
    public void setPublication_at(int publication_at) { this.publication_at = publication_at; }

    public int getPages() { return pages; }
    public void setPages(int pages) { this.pages = pages; }

    @Override
    public String toString() {
        return "ID: " + id + '\n' +
                "ISBN: " + isbn + '\n' +
                "Title: " + title + '\n' +
                "Publication: " + publication_at + '\n' +
                "Pages: " + pages + '\n';
    }
}
