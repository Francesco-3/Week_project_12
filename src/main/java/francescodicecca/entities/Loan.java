package francescodicecca.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "loans")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "element_id", nullable = false)
    private Element element;

    @Column(name = "borrow_date")
    private LocalDate borrow_date;

    @Column(name = "due_date")
    private LocalDate due_date;

    @Column(name = "return_date")
    private LocalDate return_date;

    public Loan() {}

    public Loan(User user, Element element, LocalDate borrow_date) {
        this.user = user;
        this.element = element;
        this.borrow_date = borrow_date;
        this.due_date = borrow_date.plusDays(30);

        if (user != null) {
            user.addLoan(this);
        }
    }

    public Long getId() { return id; }

    // id richiedente prestito
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    // id elemento prestato (libro o rivista)
    public Element getElement() { return element; }
    public void setElement(Element element) { this.element = element; }

    // data inizio prestito
    public LocalDate getBorrow_date() { return borrow_date; }
    public void setBorrow_date(LocalDate borrow_date) { this.borrow_date = borrow_date; }

    // data restituzione prevista
    public LocalDate getDue_date() { return due_date; }
    public void setDue_date(LocalDate due_date) { this.due_date = due_date; }

    // data restituzione effettiva
    public LocalDate getReturn_date() { return return_date; }
    public void setReturn_date(LocalDate return_date) { this.return_date = return_date; }

    public void returned(LocalDate due_date) {
        this.return_date = due_date;
    }
}
