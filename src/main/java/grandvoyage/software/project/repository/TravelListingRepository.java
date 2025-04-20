package grandvoyage.software.project.repository;

import grandvoyage.software.project.domain.Travel_Listing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelListingRepository extends JpaRepository<Travel_Listing, Integer> {

}

