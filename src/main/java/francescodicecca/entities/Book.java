package francescodicecca.entities;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book extends Element {
    @Column(name = "isbn", nullable = false, unique = true)
    private String isbn;

    @Column(name = "author")
    private String author;

    @Column(name = "pages")
    private int pages;

    @Enumerated(EnumType.STRING)
    @Column(name = "genre")
    private Genre genre;

    public Book() {}

    public Book(String title, int publicationAt, String isbn, String author, int pages, Genre genre) {
        super(title, publicationAt);
        this.isbn = isbn;
        this.author = author;
        this.pages = pages;
        this.genre = genre;
    }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public int getPages() { return pages; }
    public void setPages(int pages) { this.pages = pages; }

    public Genre getGenre() { return genre; }
    public void setGenre(Genre genre) { this.genre = genre; }

    @Override
    public String toString() {
        return super.toString() +
                "ISBN: " + isbn + "\n" +
                "Author: " + author + "\n" +
                "Pages: " + pages + "\n" +
                "Genre: " + genre + "\n";
    }
}
