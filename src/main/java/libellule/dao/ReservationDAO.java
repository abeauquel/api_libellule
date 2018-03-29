package libellule.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import libellule.domain.Reservation;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface ReservationDAO extends JpaRepository<Reservation, Integer>{
    @Query("select max(numReserv)+1 from Reservation ")
    Integer findNewNumReserveration();

    //TODO delect by client
    //TODO Find by client
    @Modifying
    @Transactional
    @Query("delete from Reservation reservation where reservation.monClient.id=?0")
    public void deleteReservationByIdClient(Integer idClient);

    /*@Query("SELECT checkIn from reservation where reservation.mon_client_id=24 ")*/
   /* @Query("SELECT numReserv from Reservation reservation where reservation.monClient.id=?0")
    public Optional<List<Reservation>> findByIdClient(Integer idClient);*/

}
