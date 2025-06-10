package grandvoyage.software.project.controller.ServiceProviderActionsSubsystem;

import grandvoyage.software.project.domain.*;
import grandvoyage.software.project.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/ServiceProviderPackage")
public class Service_Provider_Package_Controller {

    private final Package_Listing_Service packageListingService;

    @Autowired
    public Service_Provider_Package_Controller(Package_Listing_Service packageListingService) {
        this.packageListingService = packageListingService;
    }

    @PostMapping("/createPackage")
    public ResponseEntity<Package_Listing> createPackage(@RequestParam List<Accommodation_Listing> accommodationListings,
                                                         @RequestParam List<Travel_Listing> travelListings,
                                                         @RequestParam Date creation_date,
                                                         @RequestParam int numberTravelers,
                                                         @RequestParam boolean freeCancellation,
                                                         @RequestParam boolean guidedTours,
                                                         @RequestParam boolean AirportTransfers,
                                                         @RequestParam float bundle_price,
                                                         @RequestParam String status,
                                                         @RequestParam Date cancellation_date
                                                         ){
        return packageListingService.createPackage(accommodationListings,travelListings, creation_date,
                numberTravelers, freeCancellation, guidedTours, AirportTransfers, bundle_price,
                status, cancellation_date);
    }

    @PutMapping("/updatePackage/{id}")
    public ResponseEntity<Package_Listing> updatePackage(@PathVariable int id, @RequestBody Package_Listing updatePackage) {
        return packageListingService.updatePackage(id, updatePackage);
    }

    @DeleteMapping("/deletePackage/{id}")
    public ResponseEntity<Package_Listing> deletePackage(@PathVariable int id) {
        boolean isDeleted =  packageListingService.deletePackage(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}


