Tabelle: Element – Book e Magazine (Inheritance – JOINED)
Ho scelto la strategia JOINED per la gerarchia Element perché:
 - Permette di avere una tabella element unica per i campi comuni (isbn, title, pages, ecc.).
 - Evita duplicazioni e ridondanze di dati tra libri e riviste.
 - Mantiene l’integrità referenziale: ogni Book o Magazine ha una FK che punta alla tabella element.

Tabelle: User – Loan (OneToMany / ManyToOne)
 - Un utente può avere più prestiti → relazione uno a molti.
 - Un prestito appartiene a un solo utente → relazione molti a uno.

Tabelle: Loan – Element (ManyToOne)
 - Un prestito riguarda un solo elemento (libro o rivista).
 - Un elemento può essere prestato più volte nel tempo → relazione molti a uno (dal punto di vista del prestito).
 - Questo approccio semplifica la gestione dei prestiti senza creare relazioni complesse molti a molti.