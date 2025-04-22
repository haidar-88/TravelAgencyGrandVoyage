package grandvoyage.software.project.repository;

import grandvoyage.software.project.domain.ServiceProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceProviderRepository extends JpaRepository<ServiceProvider, Integer> {

    @Query("SELECT s FROM ServiceProvider s WHERE s.email_address = ?1 AND s.password = ?2")
    ServiceProvider findByEmailAddressAndPassword(String email, String password);

    @Query("""
    SELECT
      (SELECT COUNT(al)
         FROM Accommodation_Listing al
        WHERE al.contract.contract_owner = sp)
    FROM ServiceProvider sp
    WHERE sp.email_address = :email
      AND sp.password = :password
    """)
    long getTotalAccommodationListings(
            @Param("email") String email,
            @Param("password") String password
    );

    @Query("""
    SELECT
      (SELECT COUNT(al)
         FROM Travel_Listing al
        WHERE al.contract.contract_owner = sp)
    FROM ServiceProvider sp
    WHERE sp.email_address = :email
      AND sp.password = :password
    """)
    long getTotalTravelListings(
            @Param("email") String email,
            @Param("password") String password
    );

}
