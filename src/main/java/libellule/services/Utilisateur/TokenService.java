package libellule.services.Utilisateur;

import libellule.domain.Utilisateur.Token;
import libellule.domain.Utilisateur.Utilisateur;
import org.springframework.stereotype.Service;

@Service
public interface TokenService {

    Boolean tokenIsValid(String token);

    String generateToken();

    Token insertAndGeneratedOne(Utilisateur unUser);
}
