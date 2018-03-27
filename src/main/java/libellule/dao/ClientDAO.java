package libellule.dao;

import libellule.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ClientDAO extends JpaRepository<Client, Integer>{

    @Query("select max(id)+1 from Client ")
    Integer findNewIdClient();

}
