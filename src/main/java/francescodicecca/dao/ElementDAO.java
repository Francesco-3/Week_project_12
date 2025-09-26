package francescodicecca.dao;

import francescodicecca.entities.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class ElementDAO {
    private final EntityManager em;

    public ElementDAO(EntityManager em) {
        this.em = em;
    }

    // salvo un nuovo elemento
    public void save(Element element) {
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            em.persist(element);
            t.commit();
            System.out.println("\n " + element.getIsbn() + " aggiunto con successo!\n");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // elimino un elemento con isbn
    public void deleteByIsbn(String isbn) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            TypedQuery<Element> query = em.createQuery("SELECT e FROM Element e WHERE e.isbn = :isbn", Element.class);
            query.setParameter("isbn", isbn);

            Element element = query.getResultStream().findFirst().orElse(null);

            if (element != null) {
                em.remove(element);
                System.out.println("\nElemento rimosso: " + element.getTitle());
            } else {
                System.out.println("\nElemento con ISBN " + isbn + " non trovato.");
            }

            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        }
    }

    // cerco un elemento per ISBN, TITOLO, AUTORE o ANNO
    public List<Element> search(int typeSearch, String value) {
        List<Element> results = null;

        switch (typeSearch) {
            case 1 -> {
                TypedQuery<Element> query = em.createQuery("SELECT e FROM Element e WHERE e.isbn = :value", Element.class);
                query.setParameter("value", value);
                results = query.getResultList();
            }

            case 2 -> {
                TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b WHERE LOWER(b.author) LIKE LOWER(:value)", Book.class);
                query.setParameter("value", "%" + value + "%");
                results = List.copyOf(query.getResultList());
            }

            case 3 -> {
                int year;
                try {
                    year = Integer.parseInt(value);
                } catch (NumberFormatException e) {
                    System.out.println("\nAnno non valido!");
                    return List.of();
                }
                TypedQuery<Element> query = em.createQuery("SELECT e FROM Element e WHERE e.publicationAt = :value", Element.class);
                query.setParameter("value", year);
                results = query.getResultList();
            }

            case 4 -> {
                TypedQuery<Element> query = em.createQuery("SELECT e FROM Element e WHERE LOWER(e.title) LIKE LOWER(:value)", Element.class);
                query.setParameter("value", "%" + value + "%");
                results = query.getResultList();
            }

            default -> {
                System.out.println("\nTipo di ricerca non valido!");
                results = List.of();
            }
        }

        return results;
    }
}
