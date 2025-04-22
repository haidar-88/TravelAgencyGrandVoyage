package grandvoyage.software.project.repository;

import grandvoyage.software.project.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Customer findByEmailAndPassword(String email, String password);
}

