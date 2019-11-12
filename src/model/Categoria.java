package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    @Column(name = "Tipologia")
    private String tipologia;

    @OneToMany(mappedBy = "tipologia", cascade = CascadeType.ALL)
    private List<Veicoli> veicoli;


    public Categoria() {
    }

    public Categoria(String tipologia) {
        this.tipologia = tipologia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    public List<Veicoli> getVeicoli() {
        return veicoli;
    }

    public void setVeicoli(List<Veicoli> veicoli) {
        this.veicoli = veicoli;
    }
}
