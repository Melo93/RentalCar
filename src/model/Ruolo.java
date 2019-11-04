package model;

import javax.persistence.*;

@Entity
@Table(name = "ruolo")
public class Ruolo {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    @Column(name = "Descrizione")
    private String Descrizione;

    public Ruolo() {
    }

    public Ruolo(String descrizione) {
        Descrizione = descrizione;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescrizione() {
        return Descrizione;
    }

    public void setDescrizione(String descrizione) {
        Descrizione = descrizione;
    }
}
