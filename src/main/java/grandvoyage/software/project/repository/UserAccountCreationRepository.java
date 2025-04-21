package grandvoyage.software.project.repository;

import grandvoyage.software.project.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountCreationRepository extends JpaRepository<Customer, Integer> {

    boolean existsByEmail(String email);
}
