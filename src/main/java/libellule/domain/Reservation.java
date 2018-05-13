package libellule.domain;

import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.Date;
import javax.persistence.*;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "numReserv",unique=true, nullable = false)
    private Integer numReserv;

    private Date dateRecu;
    private Integer nbPersonne;
    private Integer nbEnfant;
    private Double tarifNuit;
    private Date checkIn;
    private Integer nuitee;
    private Boolean statutPaiement;
    private Date datePaiementClient;

    @ManyToOne
    private Client monClient;

    @ManyToOne
    private PlateformeReservation maPlateformeReservation;

    private Boolean annulation;
    private String remarque;

    public Reservation(){
    }

    public Integer getNumReserv() {
        return numReserv;
    }

    public void setNumReserv(Integer numReserv) {
        this.numReserv = numReserv;
    }

    public Date getDateRecu() {
        return dateRecu;
    }

    public void setDateRecu(Date dateRecu) {
        this.dateRecu = dateRecu;
    }

    public Integer getNbPersonne() {
        return nbPersonne;
    }

    public void setNbPersonne(Integer nbPersonne) {
        this.nbPersonne = nbPersonne;
    }

    public Integer getNbEnfant() {
        return nbEnfant;
    }

    public void setNbEnfant(Integer nbEnfant) {
        this.nbEnfant = nbEnfant;
    }

    public Double getTarifNuit() {
        return tarifNuit;
    }

    public void setTarifNuit(Double tarifNuit) {
        this.tarifNuit = tarifNuit;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Integer getNuitee() {
        return nuitee;
    }

    public void setNuitee(Integer nuitee) {
        this.nuitee = nuitee;
    }

    public Boolean getStatutPaiement() {
        return statutPaiement;
    }

    public void setStatutPaiement(Boolean statutPaiement) {
        this.statutPaiement = statutPaiement;
    }

    public Date getDatePaiementClient() {
        return datePaiementClient;
    }

    public void setDatePaiementClient(Date datePaiementClient) {
        this.datePaiementClient = datePaiementClient;
    }

    public Client getMonClient() {
        return monClient;
    }

    public void setMonClient(Client monClient) {
        this.monClient = monClient;
    }

    public Boolean getAnnulation() {
        return annulation;
    }

    public void setAnnulation(Boolean annulation) {
        this.annulation = annulation;
    }

    public String getRemarque() {
        return remarque;
    }

    public void setRemarque(String remarque) {
        this.remarque = remarque;
    }

    public PlateformeReservation getMaPlateformeReservation() {
        return maPlateformeReservation;
    }

    public void setMaPlateformeReservation(PlateformeReservation maPlateformeReservation) {
        this.maPlateformeReservation = maPlateformeReservation;
    }
}
