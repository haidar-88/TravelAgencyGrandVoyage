package grandvoyage.software.project.repository;

import grandvoyage.software.project.domain.Accommodation_Listing;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccommodationListingRepository extends JpaRepository<Accommodation_Listing, Integer> {

    @Transactional
    @Query("""
      SELECT a
      FROM Accommodation_Listing a
      WHERE (:accommodationName IS NULL OR a.accommodation_name = :accommodationName)
        AND (:accommodationType IS NULL OR a.accommodation_type = :accommodationType)
        AND (:starRating         IS NULL OR a.star_rating         = :starRating)
        AND (:single             IS NULL OR a.single             = :single)
        AND (:double_            IS NULL OR a.double_            = :double_)
        AND (:suite              IS NULL OR a.suite              = :suite)
        AND (:minPrice           IS NULL OR a.original_price_per_night              >= :minPrice)
        AND (:maxPrice           IS NULL OR a.original_price_per_night              <= :maxPrice)
        AND (:gym                IS NULL OR a.gym                = :gym)
        AND (:pool               IS NULL OR a.pool               = :pool)
        AND (:wifi               IS NULL OR a.wifi               = :wifi)
      """)
    List<Accommodation_Listing> findFilteredAccommodationListings(
            @Param("accommodationName") String  accommodationName,
            @Param("accommodationType") String  accommodationType,
            @Param("starRating")         Integer starRating,
            @Param("single")             Boolean single,
            @Param("double_")            Boolean double_,
            @Param("suite")              Boolean suite,
            @Param("minPrice")           Double  minPrice,
            @Param("maxPrice")           Double  maxPrice,
            @Param("gym")                Boolean gym,
            @Param("pool")               Boolean pool,
            @Param("wifi")               Boolean wifi
    );
}
