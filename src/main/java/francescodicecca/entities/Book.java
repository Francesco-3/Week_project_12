package francescodicecca.entities;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book extends Element {
    @Column(name = "author")
    private String author;

    @Enumerated(EnumType.STRING)
    @Column(name = "genre")
    private Genre genre;

    public Book() {}

    public Book(String isbn, String title, int publicationAt, int pages, String author, Genre genre) {
        super(isbn, title, publicationAt, pages);
        this.author = author;
        this.genre = genre;
    }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public Genre getGenre() { return genre; }
    public void setGenre(Genre genre) { this.genre = genre; }

    @Override
    public String toString() {
        return super.toString() +
                "Author: " + author + '\n' +
                "Genre: " + genre + '\n';
    }
}
