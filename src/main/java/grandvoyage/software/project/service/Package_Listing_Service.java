package grandvoyage.software.project.service;

import grandvoyage.software.project.domain.*;
import grandvoyage.software.project.repository.PackageListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class Package_Listing_Service {


    private final PackageListingRepository packageListingRepository;

    @Autowired
    public Package_Listing_Service(PackageListingRepository packageListingRepository) {
        this.packageListingRepository = packageListingRepository;
    }

    public List<Package_Listing> getFilteredPackages(List<String> destination, Date creation_date, int numberTravelers, boolean freeCancellation,
                                                     boolean guidedTours, boolean AirportTransfers, float bundle_price, String status,
                                                     Date cancellation_date) {
        return packageListingRepository.getFilteredPackages(destination, creation_date, numberTravelers, freeCancellation,
                guidedTours, AirportTransfers, bundle_price, status, cancellation_date);
    }

    public Package_Listing createPackage(List<Accommodation_Listing> accommodationListings,
                                         List<Travel_Listing> travelListings,
                                         private Date creation_date;
                                         private int numberTravelers;
                                         private boolean freeCancellation;
                                         private boolean guidedTours;
                                         private boolean AirportTransfers;
                                         private float bundle_price;
                                         private String status;
                                         private Date cancellation_date){
        Package_Listing packageListing = new Package_Listing();
        packageListing.getAccommodation()
        return packageListingRepository.save(packageListing);
    }

    public List<Package_Listing> getAllListings() {
        return packageListingRepository.findAll();
    }
}