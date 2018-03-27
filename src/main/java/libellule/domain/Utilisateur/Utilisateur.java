package libellule.domain.Utilisateur;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Utilisateur {
    @Id
    private String login;

    @NotNull
    private String password;

    private String Nom;

    @OneToOne
    private Token monToken;

    @ManyToOne
    private TypeUtilisateur monType;

    public Utilisateur(String login, String password, String nom) {
        this.login = login;
        this.password = password;
        Nom = nom;
    }

    public Utilisateur(){

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public Token getMonToken() {
        return monToken;
    }

    public void setMonToken(Token monToken) {
        this.monToken = monToken;
    }

    public TypeUtilisateur getMonType() {
        return monType;
    }

    public void setMonType(TypeUtilisateur monType) {
        this.monType = monType;
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", Nom='" + Nom + '\'' +
                ", monToken=" + monToken +
                ", monType=" + monType +
                '}';
    }
}
