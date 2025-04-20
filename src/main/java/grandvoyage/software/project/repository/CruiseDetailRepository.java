package grandvoyage.software.project.repository;

import grandvoyage.software.project.domain.Cruise_Detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CruiseDetailRepository extends JpaRepository<Cruise_Detail, Integer> {


    List<Cruise_Detail> getFilteredCruises(String cruiseShipName, String departurePort, String arrivalPort,
                                           Date startDate, Date endDate, Integer duration, String cabinType,
                                           Boolean spa, Boolean casino, Boolean theater, Double minPrice,
                                           Double maxPrice);
}

