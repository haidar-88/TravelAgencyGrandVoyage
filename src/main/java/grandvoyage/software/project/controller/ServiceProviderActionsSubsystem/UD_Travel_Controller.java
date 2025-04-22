package grandvoyage.software.project.controller.ServiceProviderActionsSubsystem;

import grandvoyage.software.project.domain.Cruise_Detail;
import grandvoyage.software.project.domain.Flight_Detail;
import grandvoyage.software.project.domain.Travel_Listing;
import grandvoyage.software.project.service.Travel_Listing_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/ServiceProviderTravelController")
public class UD_Travel_Controller {

    private final Travel_Listing_Service travelListingService;

    @Autowired
    public UD_Travel_Controller(Travel_Listing_Service travelListingService) {
        this.travelListingService = travelListingService;
    }

    @PutMapping("/updateFlightListing/{id}")
    public ResponseEntity<String> updateFlightListing(@PathVariable int id, @RequestBody Flight_Detail updateFlightDetail,
                                                               @RequestBody Travel_Listing updateTravelListing) {
        return travelListingService.updateFlightListing(id, updateFlightDetail, updateTravelListing);
    }

    @PutMapping("/updateCruiseListing/{id}")
    public ResponseEntity<String> updateCruiseListing(@PathVariable int id, @RequestBody Cruise_Detail updateCruiseDetail,
                                                      @RequestBody Travel_Listing updateTravelListing) {
        return travelListingService.updateCruiseListing(id, updateCruiseDetail, updateTravelListing);
    }

    @DeleteMapping("/deleteFlightListing/{id}")
    public ResponseEntity<Travel_Listing> deleteFlight(@PathVariable int id) {
        boolean isDeleted =  travelListingService.deleteFlight(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deleteCruiseListing/{id}")
    public ResponseEntity<Travel_Listing> deleteCruise(@PathVariable int id) {
        boolean isDeleted =  travelListingService.deleteCruise(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
