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

    @Query( "SELECT CASE WHEN COUNT(s) > 0 THEN true ELSE false END FROM ServiceProvider s WHERE s.email_address = :email AND s.password = :password")
    boolean existsServiceProviderByEmail_addressEqualsAndPasswordEquals(String email, String password);

}
