package grandvoyage.software.project.service;

import grandvoyage.software.project.domain.Accommodation_Booking;
import grandvoyage.software.project.domain.Accommodation_Listing;
import grandvoyage.software.project.domain.Customer;
import grandvoyage.software.project.domain.Travel_Booking;
import grandvoyage.software.project.repository.AccommodationBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class Accommodation_Booking_Service {

    private final AccommodationBookingRepository accommodationBookingRepository;

    @Autowired
    public Accommodation_Booking_Service(AccommodationBookingRepository accommodationBookingRepository){
        this.accommodationBookingRepository = accommodationBookingRepository;
    }

    public List<Travel_Booking> findCustomerBooking(Customer customer) {
        return accommodationBookingRepository.findAllByCustomer(customer);
    }

    protected Accommodation_Booking createAccommodationBooking(Accommodation_Listing accommodationListing){
        Accommodation_Booking accommodationBooking = new Accommodation_Booking();
        accommodationBooking.setBooked_on(new Date());
        accommodationBooking.setAccommodation_listing(accommodationListing);
        accommodationBooking.set_refunded(false);
        accommodationBooking.setCancellation_date(null);
        accommodationBooking.setStatus("Booked");
        accommodationBooking.setReview(null);
        accommodationBooking.setRefunding_date(null);
        return accommodationBooking;
    }
}
