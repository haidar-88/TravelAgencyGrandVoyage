package grandvoyage.software.project.repository;

import grandvoyage.software.project.domain.Customer;
import grandvoyage.software.project.domain.ServiceProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceProviderRepository extends JpaRepository<ServiceProvider, Integer> {
    ServiceProvider findByEmail_addressEqualsAndPasswordEquals(String email, String password);
    boolean existsServiceProviderByEmail_addressEqualsAndPasswordEquals(String email, String password);

}
