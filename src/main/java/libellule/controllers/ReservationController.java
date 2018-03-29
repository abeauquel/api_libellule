package libellule.controllers;

import libellule.domain.Reservation;
import libellule.services.ReservationService;
import libellule.services.Utilisateur.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @Autowired
    private TokenService tokenService;

    /***
     * Liste de toutes les réservations
     * @return List<Reservation>
     */
    @GetMapping("/reservations")
    public ResponseEntity<List<Reservation>> findAll(@RequestHeader String token) {

        if (!tokenService.tokenIsValid(token)) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        List<Reservation> allReservations = reservationService.findAll();
        return new ResponseEntity<List<Reservation>>(allReservations, HttpStatus.OK);
    }

    /***
     * Get d'une reservation
     * @return Reservation
     */
    @GetMapping("/reservation/{id}")
    public ResponseEntity<Reservation> findOne(@RequestHeader String token,@PathVariable String id) {

        if (!tokenService.tokenIsValid(token)) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        Optional<Reservation> reservation = reservationService.findOne(Integer.parseInt(id));
        if(!reservation.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Reservation>(reservation.get(), HttpStatus.OK);
    }

    @GetMapping("/reservations/client/{id}")
    public ResponseEntity<?> findAllByIdClient(@RequestHeader String token, @PathVariable String id) {

        if (!tokenService.tokenIsValid(token)) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        System.out.println(id);

        List<Reservation> allReservations = reservationService.findByIdClient(Integer.parseInt(id));
        System.out.println(id);

        /*Optional<Reservation> reservation = reservationService.findOne(Integer.parseInt(id));
        if(!reservation.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }*/
        if(allReservations.size()==0){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(allReservations, HttpStatus.OK);
    }

    /***
     * Insertion d'une reservation
     * @return Reservation
     */
    @PostMapping("/reservation")
    public ResponseEntity<Reservation> findOne(@RequestHeader String token,@RequestBody Reservation reservation) {

        if (!tokenService.tokenIsValid(token)) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        reservationService.insertOne(reservation);
        return new ResponseEntity<Reservation>(reservation, HttpStatus.OK);
    }

    @PostMapping("/reservations")
    public ResponseEntity<?> insertMany(@RequestHeader String token, @RequestBody List<Reservation> reservations) {

        if (!tokenService.tokenIsValid(token)) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        reservationService.insertMany(reservations);

        return new ResponseEntity<>(reservations ,HttpStatus.OK);
    }

    /***
     * Modification d'une reservation
     * @return Reservation
     */
    @PutMapping("/reservation")
    public ResponseEntity<Reservation> updateOne(@RequestHeader String token,@RequestBody Reservation reservation) {

        if (!tokenService.tokenIsValid(token)) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        reservationService.updateOne(reservation);
        return new ResponseEntity<Reservation>(reservation, HttpStatus.OK);
    }

    /***
     * Suppresion d'une reservation
     * @return ResponseEntity<>(HttpStatus)
     */
    @DeleteMapping("/reservation/{id}")
    public ResponseEntity<Reservation> deleteOne(@RequestHeader String token,@PathVariable String id) {

        if (!tokenService.tokenIsValid(token)) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        reservationService.deleteOne(Integer.parseInt(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
