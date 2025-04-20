package grandvoyage.software.project.service;

import grandvoyage.software.project.domain.Customer;
import grandvoyage.software.project.domain.Package_Booking;
import grandvoyage.software.project.domain.Package_Listing;
import grandvoyage.software.project.domain.Travel_Booking;
import grandvoyage.software.project.repository.PackageBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class Package_Booking_Service {

    private final PackageBookingRepository packageBookingRepository;

    @Autowired
    public Package_Booking_Service(PackageBookingRepository packageBookingRepository) {
        this.packageBookingRepository = packageBookingRepository;
    }

    public List<Travel_Booking> findCustomerBooking(Customer customer) {
        return packageBookingRepository.findAllByCustomer(customer);
    }

    protected Package_Booking createPackageBooking(Package_Listing packageListing) {
        Package_Booking packageBooking = new Package_Booking();
        packageBooking.setBooked_on_date(new Date());
        packageBooking.setPackage_listing(packageListing);
        packageBooking.set_refunded(false);
        packageBooking.setCancellation_date(null);
        packageBooking.setStatus("Booked");
        packageBooking.setReview(null);
        packageBooking.setRefunding_date(null);
        return packageBooking;
    }
}
