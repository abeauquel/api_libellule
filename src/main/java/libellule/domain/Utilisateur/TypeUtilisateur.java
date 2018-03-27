package libellule.domain.Utilisateur;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TypeUtilisateur {
    @Id  @GeneratedValue
    private int id;
    private String libelle;

    public TypeUtilisateur() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return "TypeUtilisateur{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                '}';
    }
}
