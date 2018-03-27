package libellule.controllers;

import libellule.domain.Utilisateur.Utilisateur;
import libellule.services.Utilisateur.TokenService;
import libellule.services.Utilisateur.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UtilisateurController {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UtilisateurService utilisateurService;

    @PostMapping(value ="/login")
    public ResponseEntity<?> connexion(@RequestHeader String Login, @RequestHeader String Password){

        Optional<Utilisateur> user = utilisateurService.authentification(Login, Password);

        if(!user.isPresent()){
            return new ResponseEntity<>("{message: 'Erreur authentification'}", HttpStatus.UNAUTHORIZED);
        }

        if(!(user.get().getMonToken()==null) && tokenService.tokenIsValid(user.get().getMonToken().getId())){
            return new ResponseEntity<>(user,HttpStatus.OK);
        }

        /*
        * Création d'un nouveau token pour cette utilisateur
        */
        user.get().setMonToken(tokenService.insertAndGeneratedOne(user.get()));
        utilisateurService.updateOne(user.get());
        return new ResponseEntity<>(user,HttpStatus.OK);
    }



}
