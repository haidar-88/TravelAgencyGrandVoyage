package grandvoyage.software.project.repository;

import grandvoyage.software.project.domain.Package_Listing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Date;

@Repository
public interface PackageListingRepository extends JpaRepository<Package_Listing, Integer> {

    @Query
    List<Package_Listing> getFilteredPackages(List<String> Destination, Date creationDate, int numberTravelers, boolean freeCancellation, boolean guidedTours, boolean airportTransfers, float bundlePrice, String status, Date cancellationDate);
}