package libellule.services.impl;

import libellule.dao.PlateformeReservationDAO;
import libellule.domain.PlateformeReservation;
import libellule.services.PlateformeReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlateformeReservationImpl implements PlateformeReservationService {
    @Autowired
    private PlateformeReservationDAO plateformeReservationDAO;

    @Override
    public List<PlateformeReservation> readAll() {
        return plateformeReservationDAO.findAll();
    }

    @Override
    public Optional<PlateformeReservation> readOne(int idPlateforme) {
        return plateformeReservationDAO.findById(idPlateforme);
    }

    @Override
    public void  deleteOne(int idPlateforme) {
         plateformeReservationDAO.deleteById(idPlateforme);
    }

    @Override
    public void  insertOne(PlateformeReservation unePlateforme) {
        plateformeReservationDAO.save(unePlateforme);
    }

    @Override
    public void  updateOne(PlateformeReservation unePlateforme) {
        plateformeReservationDAO.save(unePlateforme);
    }
}
