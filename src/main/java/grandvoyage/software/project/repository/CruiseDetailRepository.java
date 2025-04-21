package grandvoyage.software.project.repository;

import grandvoyage.software.project.domain.Cruise_Detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;


import java.util.Date;
import java.util.List;

@Repository
public interface CruiseDetailRepository extends JpaRepository<Cruise_Detail, Integer> {

    @Query("""
      SELECT c
      FROM Cruise_Detail c
      LEFT JOIN Travel_Listing t ON t.cruise = c
      WHERE (:cruiseShipName  IS NULL OR c.cruise_ship_name   = :cruiseShipName)
        AND (:departurePort   IS NULL OR c.departure_port    = :departurePort)
        AND (:arrivalPort     IS NULL OR c.arrival_port      = :arrivalPort)
        AND (:startDate       IS NULL OR c.embarkation_date   >= :startDate)
        AND (:endDate         IS NULL OR c.disembarkation_date   <= :endDate)
        AND (:duration        IS NULL OR c.number_of_nights   = :duration)
        AND (:cabinType       IS NULL OR c.cabin_type       = :cabinType)
        AND (:spa             IS NULL OR c.spa_available     = :spa)
        AND (:casino          IS NULL OR c.casino_available  = :casino)
        AND (:theater         IS NULL OR c.theater_available = :theater)
        AND (:minPrice        IS NULL OR t.discounted_price  >= :minPrice)
        AND (:maxPrice        IS NULL OR t.discounted_price   <= :maxPrice)
      """)
    List<Cruise_Detail> getFilteredCruises(
            @Param("cruiseShipName") String  cruiseShipName,
            @Param("departurePort")  String  departurePort,
            @Param("arrivalPort")    String  arrivalPort,
            @Param("startDate")      Date    startDate,
            @Param("endDate")        Date    endDate,
            @Param("duration")       Integer duration,
            @Param("cabinType")      String  cabinType,
            @Param("spa")            Boolean spa,
            @Param("casino")         Boolean casino,
            @Param("theater")        Boolean theater,
            @Param("minPrice")       Double  minPrice,
            @Param("maxPrice")       Double  maxPrice
    );
}


