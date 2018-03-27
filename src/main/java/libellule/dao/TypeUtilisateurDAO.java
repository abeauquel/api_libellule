package libellule.dao;

import libellule.domain.Utilisateur.TypeUtilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeUtilisateurDAO extends JpaRepository<TypeUtilisateur, String> {
}
