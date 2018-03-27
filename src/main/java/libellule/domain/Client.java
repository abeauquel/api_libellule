package libellule.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Client {
    //TODO fix la generation auto du numero client
    @Id
    /*@GeneratedValue(strategy = GenerationType.AUTO)*/
    private  Integer id;

    private String Nom;
    private String Telephone;
    private String Email;
    private String Langue;
    private String AdressePays;
    private String AdresseRegion;
    private Boolean IsGenius;

    @JsonIgnore
    @OneToMany
    private List<Reservation> mesReservations;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getTelephone() {
        return Telephone;
    }

    public void setTelephone(String telephone) {
        Telephone = telephone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getLangue() {
        return Langue;
    }

    public void setLangue(String langue) {
        Langue = langue;
    }

    public String getAdressePays() {
        return AdressePays;
    }

    public void setAdressePays(String adressePays) {
        AdressePays = adressePays;
    }

    public String getAdresseRegion() {
        return AdresseRegion;
    }

    public void setAdresseRegion(String adresseRegion) {
        AdresseRegion = adresseRegion;
    }

    public Boolean getGenius() {
        return IsGenius;
    }

    public void setGenius(Boolean genius) {
        IsGenius = genius;
    }

    public List<Reservation> getMesReservations() {
        return mesReservations;
    }

    public void setMesReservations(ArrayList<Reservation> mesReservations) {
        this.mesReservations = mesReservations;
    }
}
