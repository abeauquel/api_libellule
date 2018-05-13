package libellule.dao;

import libellule.domain.utilisateur.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurDAO extends JpaRepository<Utilisateur, String> {

}
