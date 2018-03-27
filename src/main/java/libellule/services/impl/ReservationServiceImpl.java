package libellule.services.impl;

import libellule.dao.ReservationDAO;
import libellule.domain.Reservation;
import libellule.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    private ReservationDAO reservationDAO;

    @Override
    public List<Reservation> findAll() {
        return reservationDAO.findAll();
    }

    @Override
    public Optional<Reservation> findOne(Integer idReservation) {
        return reservationDAO.findById(idReservation);
    }

    @Override
    public void insertOne(Reservation reservation) {
        /*if(reservation.getNumReserv() == null){
            reservation.setNumReserv(reservationDAO.findNewNumReserveration());
        }*/
        reservationDAO.save(reservation);
        reservationDAO.flush();

    }

    @Override
    public void insertMany(List<Reservation> reservations) {
        for (Reservation obj:reservations) {
            reservationDAO.save(obj);
        }
        reservationDAO.flush();
    }

    @Override
    public void deleteOne(Integer idReservation) {
        reservationDAO.deleteById(idReservation);
        reservationDAO.flush();
    }

    @Override
    public void updateOne(Reservation reservation) {
        reservationDAO.saveAndFlush(reservation);
    }
}
