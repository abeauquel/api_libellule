package libellule.domain.Utilisateur;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;

@Entity
public class Token {
    @Id
    private String id;
    private LocalDateTime dateDebut;
    private String ip;

    @OneToOne
    @JsonIgnore
    private Utilisateur monUtilisateur;

    public Token(){

    }

    public Token(String id) {
        this.id = id;
        this.dateDebut = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDateTime dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Utilisateur getMonUtilisateur() {
        return monUtilisateur;
    }

    public void setMonUtilisateur(Utilisateur monUtilisateur) {
        this.monUtilisateur = monUtilisateur;
    }

    @Override
    public String toString() {
        return "Token{" +
                "id='" + id + '\'' +
                ", dateDebut=" + dateDebut +
                ", ip='" + ip + '\'' +
                '}';
    }
}
