package grandvoyage.software.project.repository;

import grandvoyage.software.project.domain.Customer;
import grandvoyage.software.project.domain.Travel_Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TravelBookingRepository extends JpaRepository<Travel_Booking, Integer> {

    List<Travel_Booking> findAllByCustomer(Customer customer);
}

