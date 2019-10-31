package model.bean;

import javax.persistence.*;

@Entity
@Table(name = "utente")
public class Utente {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    @Column(name = "Nome")
    private String nome;

    @Column(name = "Cognome")
    private String cognome;

    @Column(name = "Codice_Fiscale")
    private String codiceFiscale;

    @Column(name = "Ruolo")
    private int ruolo;

    @Column(name="Username")
    private String username;

    @Column(name = "Password")
    private String password;

    public Utente() {
    }

    public Utente(String nome, String cognome, String codiceFiscale, int ruolo, String username, String password) {
        this.nome = nome;
        this.cognome = cognome;
        this.codiceFiscale = codiceFiscale;
        this.ruolo = ruolo;
        this.username=username;
        this.password=password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public int getRuolo() {
        return ruolo;
    }

    public void setRuolo(int ruolo) {
        this.ruolo = ruolo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", codiceFiscale='" + codiceFiscale + '\'' +
                ", ruolo='" + ruolo + '\'' +
                '}';
    }
}
