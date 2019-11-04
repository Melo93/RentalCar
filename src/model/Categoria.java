package model;

import javax.persistence.*;

@Entity
@Table(name = "categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    @Column(name = "Tipologia")
    private String tipologia;

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
}
