package model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "prenotazioni")
public class Prenotazioni {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "Data_inizio")
    private LocalDate dataInizio;

    @Column(name = "Data_fine")
    private LocalDate dataFine;

    @Column(name = "Stato")
    private String stato;

    @ManyToOne
    @JoinColumn(name = "Utente", referencedColumnName= "ID")
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "Veicolo", referencedColumnName= "ID")
    private Veicoli veicolo;

    @Column(name = "Data_prenotazione")
    private LocalDate dataPrenotazione;

    public Prenotazioni() {
    }

    public Prenotazioni(LocalDate dataInizio, LocalDate dataFine, String stato, Utente utente, Veicoli veicolo, LocalDate dataPrenotazione) {
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.stato = stato;
        this.utente = utente;
        this.veicolo = veicolo;
        this.dataPrenotazione=dataPrenotazione;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
    }

    public LocalDate getDataFine() {
        return dataFine;
    }

    public void setDataFine(LocalDate dataFine) {
        this.dataFine = dataFine;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente idUtente) {
        this.utente = idUtente;
    }

    public Veicoli getVeicolo() {
        return veicolo;
    }

    public void setVeicolo(Veicoli idVeicolo) {
        this.veicolo = idVeicolo;
    }

    public LocalDate getDataPrenotazione() {
        return dataPrenotazione;
    }

    public void setDataPrenotazione(LocalDate dataPrenotazione) {
        this.dataPrenotazione = dataPrenotazione;
    }

    @Override
    public String toString() {
        return "Prenotazioni{" +
                "id=" + id +
                ", dataInizio=" + dataInizio +
                ", dataFine=" + dataFine +
                ", stato='" + stato + '\'' +
                ", idUtente=" + utente.toString() +
                ", idVeicolo=" + veicolo +
                '}';
    }
}

