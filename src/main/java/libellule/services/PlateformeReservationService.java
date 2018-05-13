package libellule.services;

import libellule.domain.PlateformeReservation;

import java.util.List;
import java.util.Optional;

public interface PlateformeReservationService {
    List<PlateformeReservation> readAll();

    Optional<PlateformeReservation> readOne(int idPlateforme);

    void  deleteOne(int idPlateforme);

    void  insertOne(PlateformeReservation unePlateforme);

    void  updateOne(PlateformeReservation unePlateforme);
}
