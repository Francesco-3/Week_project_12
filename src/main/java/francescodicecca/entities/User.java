package francescodicecca.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "born_date")
    private LocalDate born_date;

    @Column(name = "card_id", unique = true)
    private String card_id;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Loan> loans = new ArrayList<>();

    public User() {}

    public User(String name, String surname, LocalDate born_date, String card_id) {
        this.name = name;
        this.surname = surname;
        this.born_date = born_date;
        this.card_id = card_id;
    }

    public Long getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }

    public LocalDate getBorn_date() { return born_date; }
    public void setBorn_date(LocalDate born_date) { this.born_date = born_date; }

    public String getCard_id() { return card_id; }
    public void setCard_id(String card_id) { this.card_id = card_id; }

    public List<Loan> getLoans() { return loans; }

    public void addLoan(Loan loan) {
        loans.add(loan);
        loan.setUser(this);
    }

    public void removeLoan(Loan loan) {
        loans.remove(loan);
        loan.setUser(null);
    }
}
