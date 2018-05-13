package libellule.services.impl;

import libellule.dao.ClientDAO;
import libellule.domain.Client;
import libellule.exception.TechnicalException;
import libellule.services.ClientService;
import libellule.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService{
    @Autowired
    private ClientDAO clientDAO;

    @Autowired
    private ReservationService reservationService;

    @Override
    public List<Client> findAll() throws TechnicalException {
        List<Client> clients = null;
        try {
            clients= clientDAO.findAll();
        } catch (Exception e) {
            throw new TechnicalException("Erreur dans le chargement de la liste des clients, "+e.getMessage());
        }
        return clients;
    }

    @Override
    public Optional<Client> findOne(Integer id) {
        return clientDAO.findById(id);
    }

    @Override
    public Client insertOne(Client client) {
        if(client.getId() == null){
            client.setId(clientDAO.findNewIdClient());
        }
        clientDAO.saveAndFlush(client);
        return client;
    }

    @Override
    public void insertMany(List<Client> clients) {
        for (Client obj:clients) {
            clientDAO.save(obj);
        }
        clientDAO.flush();
    }

    @Override
    public void deleteOne(Integer idClient) {
        reservationService.deleteByIdClient(idClient);
        clientDAO.deleteById(idClient);

        clientDAO.flush();
    }

    @Override
    public void updateOne(Client client) throws TechnicalException {

        try {
            clientDAO.saveAndFlush(client);
        } catch (Exception e) {
            throw new TechnicalException("Erreur dans l'update du client , "+ e.getMessage());

        }
    }


}
