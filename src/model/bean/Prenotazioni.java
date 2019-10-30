package model.bean;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "prenotazioni")
public class Prenotazioni {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    @Column(name = "Data_inizio")
    private Date dataInizio;

    @Column(name = "Data_fine")
    private Date dataFine;

    @Column(name = "Stato")
    private String stato;

    @Column(name = "Utente")
    private int idUtente;

    @Column(name = "Veicolo")
    private int idVeicolo;

    public Prenotazioni() {
    }

    public Prenotazioni(Date dataInizio, Date dataFine, String stato, int idUtente, int idVeicolo) {
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.stato = stato;
        this.idUtente = idUtente;
        this.idVeicolo = idVeicolo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(Date dataInizio) {
        this.dataInizio = dataInizio;
    }

    public Date getDataFine() {
        return dataFine;
    }

    public void setDataFine(Date dataFine) {
        this.dataFine = dataFine;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    public int getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(int idUtente) {
        this.idUtente = idUtente;
    }

    public int getIdVeicolo() {
        return idVeicolo;
    }

    public void setIdVeicolo(int idVeicolo) {
        this.idVeicolo = idVeicolo;
    }
}

