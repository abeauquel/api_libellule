package libellule.services.impl;

import libellule.dao.ClientDAO;
import libellule.domain.Client;
import libellule.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService{
    @Autowired
    private ClientDAO clientDAO;

    @Override
    public List<Client> findAll() {
        return clientDAO.findAll();
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
        clientDAO.deleteById(idClient);
    }

    @Override
    public void updateOne(Client client) {
        clientDAO.saveAndFlush(client);
    }


}
