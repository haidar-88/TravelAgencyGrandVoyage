package grandvoyage.software.project.controller.ServiceProviderActionsSubsystem;

import grandvoyage.software.project.domain.*;
import grandvoyage.software.project.service.Accommodation_Listing_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/ServiceProviderAccommodation")
public class Service_Provider_Accommodation_Controller {

    private final Accommodation_Listing_Service accommodationListingService;

    @Autowired
    public Service_Provider_Accommodation_Controller(Accommodation_Listing_Service accommodationListingService) {
        this.accommodationListingService = accommodationListingService;
    }

    @PostMapping("/createAccommodationListing")
    public ResponseEntity<Accommodation_Listing> createAccommodationListing(
            @RequestBody Accommodation_Listing_Service accommodationListing
    ){
        Accommodation_Listing savedListing = accommodationListingService.save(accommodationListing);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedListing);
    }

    @PutMapping("/updateAccommodationListing/{id}")
    public ResponseEntity<String> updateAccommodationListing(@PathVariable int id, @RequestBody Accommodation_Listing accommodationListing) {
        return accommodationListingService.updateAccommodationListing(id, accommodationListing);
    }

    @DeleteMapping("/deleteAccommodationListing/{id}")
    public ResponseEntity<Accommodation_Listing> deleteAccommodationListing(@PathVariable int id) {
        boolean isDeleted =  accommodationListingService.deleteAccommodationListing(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
