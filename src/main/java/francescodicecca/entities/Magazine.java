package francescodicecca.entities;

import javax.persistence.*;

@Entity
@Table(name = "magazines")
public class Magazine extends Element {
    @Enumerated(EnumType.STRING)
    @Column(name = "periodical")
    private Periodical periodical;

    public Magazine() {}

    public Magazine(String isbn, String title, int publicationAt, int pages, Periodical periodical) {
        super(isbn, title, publicationAt, pages);
        this.periodical = periodical;
    }

    public Periodical getPeriodical() { return periodical; }
    public void setPeriodical(Periodical periodical) { this.periodical = periodical; }

    @Override
    public String toString() {
        return super.toString() +
                "Periodical: " + periodical + '\n';
    }
}
