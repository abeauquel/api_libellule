package libellule.services.Utilisateur.implUtilisateur;

import libellule.dao.UtilisateurDAO;
import libellule.domain.Utilisateur.Utilisateur;
import libellule.services.Utilisateur.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurServiceImpl implements UtilisateurService{

    @Autowired
    private UtilisateurDAO utilisateurDAO;


    @Override
    public List<Utilisateur> findAll() {
        return utilisateurDAO.findAll();
    }

    @Override
    public Optional<Utilisateur> findById(String id) {
        return utilisateurDAO.findById(id);
    }

    /***
     * Renvoi l'utilisateur si login, password correct
     * @param login login de l'utilisateur
     * @param password mot de passe de l'utilisateur
     * @return Optional<Utilisateur>
     */
    @Override
    public Optional<Utilisateur> authentification(String login, String password){
        Optional<Utilisateur> user = utilisateurDAO.findById(login);

        if(user.isPresent() && user.get().getPassword().equals(password)){
            return user;
        }
        return Optional.empty();
    }

    @Override
    public void insertOne(Utilisateur user) {
        utilisateurDAO.save(user);
        utilisateurDAO.flush();

    }

    @Override
    public void insertMany(List<Utilisateur> users) {
        //TODO à completer
    }

    @Override
    public void deleteOne(Integer idUser) {
        //TODO à completer
    }

    @Override
    public void updateOne(Utilisateur user) {
        utilisateurDAO.save(user);
        utilisateurDAO.flush();
    }

}
