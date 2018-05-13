package libellule.services.utilisateur.implUtilisateur;

import libellule.dao.TokenDAO;
import libellule.domain.utilisateur.Token;
import libellule.domain.utilisateur.Utilisateur;
import libellule.services.utilisateur.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class TokenServiceImpl implements TokenService {
    private static final int HOURS_VALDIATION_TOKEN = 1;
    private final TokenDAO tokenDAO;

    private static SecureRandom random = new SecureRandom();

    @Autowired
    public TokenServiceImpl(TokenDAO tokenDAO) {
        this.tokenDAO = tokenDAO;
    }

    /***
     * Si un token est encore valide sa date est remis à zero
     * @param tokenId id du token
     * @return Vrai si token encore valide
     */
    @Override
    public Boolean tokenIsValid(String tokenId) {
        Optional<Token> unToken = tokenDAO.findById(tokenId);

        if(! unToken.isPresent()){
            return false;
        }

        LocalDateTime today = LocalDateTime.now();
        Duration dReel = Duration.between(unToken.get().getDateDebut(), today);
        Duration dLimite = Duration.ofHours(HOURS_VALDIATION_TOKEN);

        if (dReel.compareTo(dLimite) >=  HOURS_VALDIATION_TOKEN){
            System.out.println("token épuisé");
            return false;
        }
        System.out.println("Token encore valide ---> date réintialisé");
        unToken.get().setDateDebut(today);
        tokenDAO.save(unToken.get());
        tokenDAO.flush();

        return true;
    }

    @Override
    public synchronized String generateToken() {
        long longToken = Math.abs( random.nextLong() );
        return (Long.toString( longToken, 16 ));
    }

    /***
     * Suppression des anciens token et creation d'un nouvelle objet token lié à un utilisateur
     * @param unUser utilisateur
     * @return Token
     */
    @Override
    public Token insertAndGeneratedOne(Utilisateur unUser){
/*
        tokenDAO.deleteAllByIdUtilisateur(unUser.getLogin());
*/
        Token unToken = new Token(generateToken());

        unToken.setMonUtilisateur(unUser);

        tokenDAO.save(unToken);
        tokenDAO.flush();
       /* unToken.setMonUtilisateur(null);
        unToken.toString();*/
        return  unToken;
    }
}
