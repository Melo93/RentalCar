package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "veicoli")
public class Veicoli implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Tipologia")
    private Categoria tipologia;

    @Column(name = "Prezzo")
    private int prezzo;

    @Column(name = "img_URL")
    private String urlImg;

    @OneToMany(mappedBy = "veicolo")
    List<Prenotazioni> prenotazioni;

    public Veicoli() {
    }

    public Veicoli(String targa, String costruttore, String modello, int annoCostruzione, Categoria tipologia, int prezzo, String urlImg) {
        this.targa = targa;
        this.costruttore = costruttore;
        this.modello = modello;
        this.annoCostruzione = annoCostruzione;
        this.tipologia = tipologia;
        this.prezzo = prezzo;
        this.urlImg=urlImg;
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

    public Categoria getTipologia() {
        return tipologia;
    }

    public void setTipologia(Categoria tipologia) {
        this.tipologia = tipologia;
    }

    public int getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(int prezzo) {
        this.prezzo = prezzo;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public List<Prenotazioni> getPrenotazioni() {
        return prenotazioni;
    }

    public void setPrenotazioni(List<Prenotazioni> prenotazioni) {
        this.prenotazioni = prenotazioni;
    }

    @Override
    public String toString() {
        return "Veicoli{" +
                "id=" + id +
                ", targa='" + targa + '\'' +
                ", costruttore='" + costruttore + '\'' +
                ", modello='" + modello + '\'' +
                ", annoCostruzione=" + annoCostruzione +
                ", tipologia=" + tipologia +
                ", prezzo=" + prezzo +
                ", urlImg='" + urlImg + '\''+
                '}';
    }
}
