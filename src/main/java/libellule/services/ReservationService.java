package libellule.services;

import libellule.domain.Reservation;
import java.util.List;
import java.util.Optional;

public interface ReservationService {
    List<Reservation> findAll();

    Optional<Reservation> findOne(Integer idReservation);

    void insertOne(Reservation reservation);

    void insertMany(List<Reservation> reservations);

    void deleteOne(Integer idReservation);

    void updateOne(Reservation reservation);

    List<Reservation> findByIdClient(Integer idClient);

    void deleteByIdClient(Integer idClient);
}
