package libellule.services.utilisateur;

import libellule.domain.utilisateur.Token;
import libellule.domain.utilisateur.Utilisateur;
import org.springframework.stereotype.Service;

@Service
public interface TokenService {

    Boolean tokenIsValid(String token);

    String generateToken();

    Token insertAndGeneratedOne(Utilisateur unUser);
}
