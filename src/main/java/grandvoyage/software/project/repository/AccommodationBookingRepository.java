package grandvoyage.software.project.repository;

import grandvoyage.software.project.domain.Customer;
import grandvoyage.software.project.domain.Travel_Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import grandvoyage.software.project.domain.Accommodation_Booking;

import java.util.List;


@Repository
public interface AccommodationBookingRepository extends JpaRepository<Accommodation_Booking, Integer> {

    List<Accommodation_Booking> findAllByCustomer(Customer customer);
}
