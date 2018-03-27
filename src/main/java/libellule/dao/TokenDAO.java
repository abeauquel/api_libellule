package libellule.dao;
import libellule.domain.Utilisateur.Token;
import libellule.domain.Utilisateur.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenDAO  extends JpaRepository<Token, String>{

}
