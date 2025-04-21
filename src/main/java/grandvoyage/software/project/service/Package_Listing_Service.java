package grandvoyage.software.project.service;

import grandvoyage.software.project.domain.*;
import grandvoyage.software.project.repository.PackageListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    public ResponseEntity<Package_Listing> createPackage(List<Accommodation_Listing> accommodationListings,
                                                         List<Travel_Listing> travelListings,
                                                          Date creation_date,
                                                          int numberTravelers,
                                                          boolean freeCancellation,
                                                          boolean guidedTours,
                                                          boolean AirportTransfers,
                                                          float bundle_price,
                                                          String status,
                                                          Date cancellation_date){
        Package_Listing packageListing = new Package_Listing();
        packageListing.setAccommodation(accommodationListings);
        packageListing.setTravel(travelListings);
        packageListing.setCreation_date(creation_date);
        packageListing.setNumberTravelers(numberTravelers);
        packageListing.setFreeCancellation(freeCancellation);
        packageListing.setGuidedTours(guidedTours);
        packageListing.setAirportTransfers(AirportTransfers);
        packageListing.setBundle_price(bundle_price);
        packageListing.setStatus(status);
        packageListing.setCancellation_date(cancellation_date);

        packageListingRepository.save(packageListing);
        return new ResponseEntity<>(packageListing, HttpStatus.CREATED);
    }

    public ResponseEntity<Package_Listing> updatePackage(int id, Package_Listing updatePackage) {
        Package_Listing packageListingToUpdate = packageListingRepository.getReferenceById(id);
        if (updatePackage.getAccommodation() != null) {
            packageListingToUpdate.setAccommodation(updatePackage.getAccommodation());
        }
        if (updatePackage.getTravel() != null) {
            packageListingToUpdate.setTravel(updatePackage.getTravel());
        }
        if (updatePackage.getCreation_date() != null) {
            packageListingToUpdate.setCreation_date(updatePackage.getCreation_date());
        }
        if (updatePackage.getNumberTravelers() != null) {
            packageListingToUpdate.setNumberTravelers(updatePackage.getNumberTravelers());
        }
        if (updatePackage.getFreeCancellation() != null) {
            packageListingToUpdate.setFreeCancellation(updatePackage.getFreeCancellation());
        }
        if (updatePackage.getGuidedTours() != null) {
            packageListingToUpdate.setGuidedTours(updatePackage.getGuidedTours());
        }
        if (updatePackage.getAirportTransfers() != null) {
            packageListingToUpdate.setAirportTransfers(updatePackage.getAirportTransfers());
        }
        if (updatePackage.getBundle_price() != null) {
            packageListingToUpdate.setBundle_price(updatePackage.getBundle_price());
        }
        if (updatePackage.getStatus() != null) {
            packageListingToUpdate.setStatus(updatePackage.getStatus());
        }
        if (updatePackage.getCancellation_date() != null) {
            packageListingToUpdate.setCancellation_date(updatePackage.getCancellation_date());
        }


        Package_Listing updated = packageListingRepository.save(packageListingToUpdate);
        return ResponseEntity.ok(updated);
    }

    public boolean deletePackage(int id) {
        if(packageListingRepository.existsById(id)) {
            packageListingRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Package_Listing> getAllListings() {
        return packageListingRepository.findAll();
    }
}


