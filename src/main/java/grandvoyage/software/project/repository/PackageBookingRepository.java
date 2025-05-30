package grandvoyage.software.project.repository;

import grandvoyage.software.project.domain.Customer;
import grandvoyage.software.project.domain.Package_Booking;
import grandvoyage.software.project.domain.Travel_Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PackageBookingRepository extends JpaRepository<Package_Booking, Integer> {

    List<Package_Booking> findAllByCustomer(Customer customer);
}

