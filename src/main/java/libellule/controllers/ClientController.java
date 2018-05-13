package libellule.controllers;

import libellule.domain.Client;
import libellule.exception.TechnicalException;
import libellule.services.ClientService;
import libellule.services.utilisateur.TokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ClientController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    private ClientService clientService;

    @Autowired
    private TokenService tokenService;

    /***
     * Liste de tous les clients
     * @param token String
     * @return List<Client>
     */
    @GetMapping("/clients")
    public ResponseEntity<?> findAll(@RequestHeader String token) {

        if(!tokenService.tokenIsValid(token)){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        System.out.println("chargement des clients");


        List<Client> lesClients = null;
        try {
            lesClients = clientService.findAll();
        } catch (TechnicalException e) {
            e.printStackTrace();
        }
        assert lesClients != null;
        return new ResponseEntity<List<Client>>(lesClients, HttpStatus.OK);
    }

    /***
     * Get d'un seul client
     * @param token String
     * @param idclient Id du client
     * @return Client
     */
    @GetMapping("/client/{idclient}")
    public ResponseEntity<?> findOne(@RequestHeader String token, @PathVariable String idclient){
        System.out.println("Mon id : "+ idclient);

        if(!tokenService.tokenIsValid(token)) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        Optional<Client> unClient = clientService.findOne(Integer.parseInt(idclient));

        if(!unClient.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        }
        return new ResponseEntity<Client>(unClient.get(), HttpStatus.OK);

    }

    /***
     * Insertion d'un client
     * @param token String
     * @param client Client
     * @return ResponseEntity<?>
     */
    @PostMapping("/client")
    public ResponseEntity<?> insertOne(@RequestHeader String token, @RequestBody Client client){

        if(!tokenService.tokenIsValid(token)){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        client = clientService.insertOne(client);
        return new ResponseEntity<Client>(client, HttpStatus.OK);
    }

    /***
     * Insertion d'une liste de client
     * @param clients List<Client>
     * @return ResponseEntity<?>
     */
    @PostMapping("/clients")
    public ResponseEntity<?> insertMany(@RequestBody List<Client> clients){

        clientService.insertMany(clients);
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    /***
     * Modification d'une client
     * @param token String
     * @param unClient Client
     * @return ResponseEntity<?>
     */
    @PutMapping("/client")
    public ResponseEntity<?> updateOne(@RequestHeader String token, @RequestParam("Client") Client unClient){

        if(!tokenService.tokenIsValid(token)){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        try {
            clientService.updateOne(unClient);
        } catch (TechnicalException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<Client>(unClient, HttpStatus.OK);
    }

    /***
     * Suppresion d'un client
     * @param token String
     * @param idclient String
     * @return ResponseEntity<?>
     */
    @DeleteMapping("/client/{idclient}")
    public ResponseEntity<?> deleteBazz(@RequestHeader String token,  @PathVariable String idclient){

        if(!tokenService.tokenIsValid(token)){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        clientService.deleteOne(Integer.parseInt(idclient));

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
