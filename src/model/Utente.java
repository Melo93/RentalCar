package model;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

@Entity
@Table(name = "utente")
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Column(name = "Username")
    private String username;

    @Column(name = "Password")
    private String password;

    @Column(name = "Data_di_nascita")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate dataDiNascita;


    public Utente() {
    }

    public Utente(String nome, String cognome, String codiceFiscale, LocalDate dataDiNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.codiceFiscale = codiceFiscale;
        this.dataDiNascita = dataDiNascita;
    }

    public Utente(String nome, String cognome, String codiceFiscale, int ruolo, String username, String password, LocalDate dataDiNascita) throws ParseException {
        this.nome = nome;
        this.cognome = cognome;
        this.codiceFiscale = codiceFiscale;
        this.ruolo = ruolo;
        this.username = username;
        this.password = password;
        this.dataDiNascita = dataDiNascita;
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

    public LocalDate getDataDiNascita() throws ParseException {
        return dataDiNascita;
    }

    public void setDataDiNascita(LocalDate dataDiNascita) throws ParseException {
        this.dataDiNascita = dataDiNascita;
    }

    public void overwrite(Utente u) throws ParseException {
        if (u.getNome() != null) {
            this.setNome(u.getNome());
        }
        if (u.getCognome() != null) {
            this.setCognome(u.getCognome());
        }
        if (u.getCodiceFiscale() != null) {
            this.setCodiceFiscale(u.getCodiceFiscale());
        }
        if (u.getDataDiNascita() != null) {
            this.setDataDiNascita(u.getDataDiNascita());
        }
    }

    @Override
    public String toString() {
        return "Utente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", codiceFiscale='" + codiceFiscale + '\'' +
                ", ruolo=" + ruolo +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", dataDiNascita=" + dataDiNascita +
                '}';
    }
}
