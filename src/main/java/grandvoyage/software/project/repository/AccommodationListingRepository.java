package grandvoyage.software.project.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import grandvoyage.software.project.domain.Accommodation_Listing;

import java.util.List;


@Repository
public interface AccommodationListingRepository extends JpaRepository<Accommodation_Listing, Integer> {


    List<Accommodation_Listing> findFilteredAccommodationListings(String accommodationName, String accommodationType,
                                                                  Integer starRating, Boolean single,
                                                                  Boolean double_, Boolean suite, Double minPrice,
                                                                  Double maxPrice, Boolean gym, Boolean pool,
                                                                  Boolean wifi);
}

