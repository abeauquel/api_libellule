package libellule.domain;

import javax.persistence.*;


@Entity
public class PlateformeReservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPlateforme", unique = true, nullable = false)
    private Integer id;

    @Column(name="libellePlateforme" , nullable = false)
    private String libelle;

    @Column(name="tauxCommission", nullable = false)
    private Double tauxCommission;

    public PlateformeReservation(){}

    public PlateformeReservation(Integer id){
        this.id=id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Double getTauxCommission() {
        return tauxCommission;
    }

    public void setTauxCommission(Double tauxCommission) {
        this.tauxCommission = tauxCommission;
    }
}