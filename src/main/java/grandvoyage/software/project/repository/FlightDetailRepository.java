package grandvoyage.software.project.repository;

import grandvoyage.software.project.domain.Flight_Detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface FlightDetailRepository extends JpaRepository<Flight_Detail, Integer> {

    @Query("""
      SELECT f
      FROM Flight_Detail f
      LEFT JOIN Travel_Listing t ON t.flight = f
      WHERE (:airline           IS NULL OR f.airline_name           = :airline)
        AND (:departureAirport  IS NULL OR f.departure_airport  = :departureAirport)
        AND (:arrivalAirport    IS NULL OR f.arrival_airport    = :arrivalAirport)
        AND (:minDuration       IS NULL OR f.flight_duration          >= :minDuration)
        AND (:maxDuration       IS NULL OR f.flight_duration          <= :maxDuration)
        AND (:minPrice          IS NULL OR t.discounted_price             >= :minPrice)
        AND (:maxPrice          IS NULL OR t.discounted_price             <= :maxPrice)
        AND (:cabinClass        IS NULL OR f.cabin_class        = :cabinClass)
        AND (:baggageAllowance  IS NULL OR f.baggage_allowance  >= :baggageAllowance)
        AND (:departureDate     IS NULL OR f.departure_date     = :departureDate)
        AND (:mealsIncluded     IS NULL OR f.meal_included     = :mealsIncluded)
      """)
    List<Flight_Detail> getFilteredFlights(
            @Param("airline")           String  airline,
            @Param("departureAirport")  String  departureAirport,
            @Param("arrivalAirport")    String  arrivalAirport,
            @Param("minDuration")       Integer minDuration,
            @Param("maxDuration")       Integer maxDuration,
            @Param("minPrice")          Double  minPrice,
            @Param("maxPrice")          Double  maxPrice,
            @Param("cabinClass")        String  cabinClass,
            @Param("baggageAllowance")  Integer baggageAllowance,
            @Param("departureDate")     Date    departureDate,
            @Param("mealsIncluded")     Boolean mealsIncluded,
            @Param("noLayover")         Boolean noLayover
    );
}
