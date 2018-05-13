package libellule.dao;

import libellule.domain.PlateformeReservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlateformeReservationDAO extends JpaRepository<PlateformeReservation, Integer> {
}
