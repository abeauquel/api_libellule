package libellule.services.impl;

import libellule.dao.ReservationDAO;
import libellule.domain.Reservation;
import libellule.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.AbstractList;
import java.util.ArrayList;
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

    @Override
    public List<Reservation> findByIdClient(Integer idClient) {
       List<Reservation> reservations = reservationDAO.findAll();
       List<Reservation> reservationByIdClient= new ArrayList<Reservation>();

       for(Reservation reservation:reservations){
           if(reservation.getMonClient().getId().equals(idClient)){
               reservationByIdClient.add(reservation);
           }
       }
       return reservationByIdClient;
    }

    @Override
    public void deleteByIdClient(Integer idClient) {
        List<Reservation> reservationByIdClient= findByIdClient(idClient);

        for(Reservation reservation:reservationByIdClient){
            reservationDAO.deleteById(reservation.getNumReserv());
        }
        reservationDAO.flush();
    }
}
