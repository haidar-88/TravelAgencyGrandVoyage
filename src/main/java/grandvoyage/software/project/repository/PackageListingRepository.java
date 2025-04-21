package grandvoyage.software.project.repository;

import grandvoyage.software.project.domain.Package_Listing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PackageListingRepository extends JpaRepository<Package_Listing, Integer> {

    // (:destinations      IS NULL OR p.destinations      IN :destinations)
    @Query("""
      SELECT p
      FROM Package_Listing p
        WHERE (:creationDate      IS NULL OR p.creation_date     >= :creationDate)
        AND (:numberTravelers   IS NULL OR p.numberTravelers  = :numberTravelers)
        AND (:freeCancellation  IS NULL OR p.freeCancellation = :freeCancellation)
        AND (:guidedTours       IS NULL OR p.guidedTours      = :guidedTours)
        AND (:airportTransfers  IS NULL OR p.AirportTransfers = :airportTransfers)
        AND (:bundlePrice       IS NULL OR p.bundle_price      <= :bundlePrice)
        AND (:status            IS NULL OR p.status           = :status)
        AND (:cancellationDate  IS NULL OR p.cancellation_date <= :cancellationDate)
      """)
    List<Package_Listing> getFilteredPackages(
            @Param("destinations")     List<String> destinations,
            @Param("creationDate")     Date         creationDate,
            @Param("numberTravelers")  Integer      numberTravelers,
            @Param("freeCancellation") Boolean      freeCancellation,
            @Param("guidedTours")      Boolean      guidedTours,
            @Param("airportTransfers") Boolean      airportTransfers,
            @Param("bundlePrice")      Float        bundlePrice,
            @Param("status")           String       status,
            @Param("cancellationDate") Date         cancellationDate
    );
}
