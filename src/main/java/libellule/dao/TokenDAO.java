package libellule.dao;
import libellule.domain.utilisateur.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenDAO  extends JpaRepository<Token, String>{

}
