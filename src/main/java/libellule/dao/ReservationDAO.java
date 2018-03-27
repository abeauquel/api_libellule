package libellule.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import libellule.domain.Reservation;
import org.springframework.data.jpa.repository.Query;

public interface ReservationDAO extends JpaRepository<Reservation, Integer>{
    @Query("select max(numReserv)+1 from Reservation ")
    Integer findNewNumReserveration();
}
