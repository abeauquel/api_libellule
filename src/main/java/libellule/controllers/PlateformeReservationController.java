package libellule.controllers;

import libellule.domain.PlateformeReservation;
import libellule.services.PlateformeReservationService;
import libellule.services.utilisateur.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlateformeReservationController {
    @Autowired
    private TokenService tokenService;

    @Autowired
    private PlateformeReservationService plateformeReservationService;

    /***
     * Liste de toutes les plateformes de réservations
     * @param token String
     * @return List<Client>
     */
    @GetMapping("/plateformes")
    public ResponseEntity<?> findAll(@RequestHeader String token) {

        if(!tokenService.tokenIsValid(token)){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        System.out.println("chargement des plateformes");

        List<PlateformeReservation> lesPlateformes = plateformeReservationService.readAll();
        return new ResponseEntity<List<PlateformeReservation>>(lesPlateformes, HttpStatus.OK);
    }

    /***
     * Suppréssion d'une plateforme de réservation à partir de son id
     * @param token String
     * @param idPlateformeReservation id de la plateforme
     * @return
     */
    @DeleteMapping("/plateforme/{idPlateforme}")
    public ResponseEntity<?> deleteOne(@RequestHeader String token, @PathVariable String idPlateformeReservation) {

        if(!tokenService.tokenIsValid(token)){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        System.out.println("suppression de la plateforme de réservation");

        plateformeReservationService.deleteOne(Integer.parseInt(idPlateformeReservation));

        return new ResponseEntity<>(HttpStatus.OK);
    }

    /***
     * Modification d'une plateforme
     * @param token String
     * @param unePlateformeReservation PlateformeReservation
     * @return
     */
    @PutMapping("/plateforme")
    public ResponseEntity<?> updateOne(@RequestHeader String token, @RequestParam("PlateformeReservation") PlateformeReservation unePlateformeReservation){

        if(!tokenService.tokenIsValid(token)){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        plateformeReservationService.updateOne(unePlateformeReservation);
        return new ResponseEntity<PlateformeReservation>(unePlateformeReservation, HttpStatus.OK);
    }

}
