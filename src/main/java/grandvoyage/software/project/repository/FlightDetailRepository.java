package grandvoyage.software.project.repository;

import grandvoyage.software.project.domain.Flight_Detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface FlightDetailRepository extends JpaRepository<Flight_Detail, Integer> {

    @Query()
    List<Flight_Detail> getFilteredFlights(String airline, String departureAirport, String arrivalAirport, Integer minDuration, Integer maxDuration, Double minPrice, Double maxPrice, String cabinClass, Integer baggageAllowance, Date departureDate, Boolean mealsIncluded, Boolean noLayover);
}

