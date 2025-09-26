package francescodicecca;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import francescodicecca.dao.ElementDAO;
import francescodicecca.entities.*;
import java.util.*;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("book_catalog");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        Scanner scanner = new Scanner(System.in);
        ElementDAO ed = new ElementDAO(em);

        // AGGIUNGO UN ELEMENTO
       try {
            System.out.print("\nScegli cosa inserire (1 - Libro, 2 - Rivista): ");
            int option = scanner.nextInt();
            scanner.nextLine();

            // questi dati sono comuni
            System.out.print("ISBN: ");
            String isbn = scanner.nextLine();

            System.out.print("Titolo: ");
            String title = scanner.nextLine();

            System.out.print("Anno di pubblicazione: ");
            int year = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Numero pagine: ");
            int pages = scanner.nextInt();
            scanner.nextLine();

            Element newElement = null;

            switch (option) {
                case 1 -> {
                    System.out.print("Autore: ");
                    String author = scanner.nextLine();

                    System.out.print("Genere (NARRATIVA, FANTASCIENZA, FANTASY, GIALLO, THRILLER, ROMANZO, BIOGRAFIA, HORROR, POESIA2): ");
                    String genreStr = scanner.nextLine().toUpperCase();
                    Genre genre = Genre.valueOf(genreStr);

                    newElement = new Book(isbn, title, year, pages, author, genre);
                }

                case 2 -> {
                    System.out.print("Periodicità (SETTIMANALE, MENSILE, SEMESTRALE): ");
                    String periodicalStr = scanner.nextLine().toUpperCase();
                    Periodical periodical = Periodical.valueOf(periodicalStr);

                    newElement = new Magazine(isbn, title, year, pages, periodical);
                }

                default -> System.out.println("Scelta non valida.");
            }

            ed.save(newElement);

        } finally {
            em.close();
            emf.close();
        }
/*
        // RIMUOVO UN ELEMENTO TRAMITE ISBN
        System.out.print("\nInserisci l'ISBN dell'elemento da rimuovere: ");
        String isbnToDelete = scanner.nextLine();

        ed.deleteByIsbn(isbnToDelete);

        // CERCO UN ELEMENTO PER ISBN, AUTORE, ANNO DI PUBBLICAZIONE o TITOLO
        System.out.println("1 = ISBN");
        System.out.println("2 = Autore");
        System.out.println("3 = Anno di pubblicazione");
        System.out.println("4 = Titolo");
        System.out.print("Seleziona tipo di ricerca: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        System.out.print("\nInserisci il valore da cercare: ");
        String value = scanner.nextLine();

        List<Element> results = ed.search(choice, value);

        if (results.isEmpty()) {
            System.out.println("\nNessun risultato trovato.");
        } else {
            System.out.println("\nRisultati trovati:");
            results.forEach(System.out::println);
        }*/
    }
}
