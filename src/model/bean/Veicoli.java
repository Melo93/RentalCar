package model.bean;

import javax.persistence.*;

@Entity
@Table(name = "veicoli")
public class Veicoli {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    @Column(name = "Targa")
    private String targa;

    @Column(name = "Costruttore")
    private String costruttore;

    @Column(name = "Modello")
    private String modello;

    @Column(name = "Anno_costruzione")
    private int annoCostruzione;

    @Column(name = "Tipologia")
    private int tipologia;

    public Veicoli() {
    }

    public Veicoli(String targa, String costruttore, String modello, int annoCostruzione, int tipologia) {
        this.targa = targa;
        this.costruttore = costruttore;
        this.modello = modello;
        this.annoCostruzione = annoCostruzione;
        this.tipologia = tipologia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public String getCostruttore() {
        return costruttore;
    }

    public void setCostruttore(String costruttore) {
        this.costruttore = costruttore;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public int getAnnoCostruzione() {
        return annoCostruzione;
    }

    public void setAnnoCostruzione(int annoCostruzione) {
        this.annoCostruzione = annoCostruzione;
    }

    public int getTipologia() {
        return tipologia;
    }

    public void setTipologia(int tipologia) {
        this.tipologia = tipologia;
    }
}
