package grandvoyage.software.project.controller.ServiceProviderActionsSubsystem;

import grandvoyage.software.project.domain.*;
import grandvoyage.software.project.service.Accommodation_Listing_Service;
import grandvoyage.software.project.service.Travel_Listing_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/ServiceProviderTravelController")
public class UD_Accommodation_Controller {

    private final Accommodation_Listing_Service accommodationListingService;

    @Autowired
    public UD_Accommodation_Controller(Accommodation_Listing_Service accommodationListingService) {
        this.accommodationListingService = accommodationListingService;
    }

    @PutMapping("/updateAccommodationListing/{id}")
    public ResponseEntity<String> updateAccommodationListing(@PathVariable int id, @RequestBody Accommodation_Listing accommodationListing) {
        return accommodationListingService.updateAccommodationListing(id, accommodationListing);
    }

    @DeleteMapping("/deleteAccommodationListing/{id}")
    public ResponseEntity<Accommodation_Listing> deleteAccomodationListing(@PathVariable int id) {
        boolean isDeleted =  accommodationListingService.deleteAccommodationListing(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
