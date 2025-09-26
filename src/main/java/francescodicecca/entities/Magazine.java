package francescodicecca.entities;

import javax.persistence.*;

@Entity
@Table(name = "magazines")
public class Magazine extends Element {
    @Enumerated(EnumType.STRING)
    @Column(name = "periodical")
    private Periodical periodical;

    public Magazine() {}

    public Magazine(String title, int publicationAt, Periodical periodical) {
        super(title, publicationAt);
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
