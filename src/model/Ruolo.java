package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ruolo")
public class Ruolo {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "Descrizione", unique = true)
    private String descrizione;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "ruolo")
    private List<Utente> utenti ;

    public Ruolo() {
    }

    public Ruolo(String descrizione) {
        this.descrizione = descrizione;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    @Override
    public String toString() {
        return "Ruolo{" +
                "id=" + id +
                ", descrizione='" + descrizione + '\'' +
                '}';
    }

    public List<Utente> getUtenti() {
        return utenti;
    }

    public void setUtenti(List<Utente> utenti) {
        this.utenti = utenti;
    }
}
