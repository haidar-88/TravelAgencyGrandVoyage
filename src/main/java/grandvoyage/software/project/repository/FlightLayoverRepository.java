package grandvoyage.software.project.repository;

import grandvoyage.software.project.domain.Flight_Layover;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightLayoverRepository extends JpaRepository<Flight_Layover, Integer> {

}

