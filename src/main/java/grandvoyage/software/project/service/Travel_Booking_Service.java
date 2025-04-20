package grandvoyage.software.project.service;

import grandvoyage.software.project.domain.*;
import grandvoyage.software.project.repository.TravelBookingRepository;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class Travel_Booking_Service {

    private final TravelBookingRepository travelBookingRepository;

    @Autowired
    public Travel_Booking_Service(TravelBookingRepository travelBookingRepository) {
        this.travelBookingRepository = travelBookingRepository;
    }

    public List<Travel_Booking> findCustomerBooking(Customer customer) {
        return travelBookingRepository.findAllByCustomer(customer);
    }


    protected Travel_Booking createTravelBooking(Travel_Listing travelListing) {
        Travel_Booking travelBooking = new Travel_Booking();
        travelBooking.setBooked_on_date(new Date());
        travelBooking.setTravel_listing(travelListing);
        travelBooking.set_refunded(false);
        travelBooking.setCancellation_date(null);
        travelBooking.setStatus("Booked");
        travelBooking.setReview(null);
        travelBooking.setRefunding_date(null);
        return travelBooking;
    }
}
