package grandvoyage.software.project.controller.UserViewsModule;

import grandvoyage.software.project.domain.*;
import grandvoyage.software.project.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/packageListing")
public class Packages_Listing_Controller {

    private final Package_Listing_Service packageListingService;

    @Autowired
    public Packages_Listing_Controller(Package_Listing_Service packageListingService) {
        this.packageListingService = packageListingService;
    }

    @GetMapping("/filteredPackages")
    public List<Package_Listing> getFilteredPackages(
            @RequestParam(required = false) List<String> Destination,
            @RequestParam(required = false) Date creation_date,
            @RequestParam(required = false) int numberTravelers,
            @RequestParam(required = false) boolean freeCancellation,
            @RequestParam(required = false) boolean guidedTours,
            @RequestParam(required = false) boolean AirportTransfers,
            @RequestParam(required = false) float bundle_price,
            @RequestParam(required = false) String status,
            @RequestParam(required = false) Date cancellation_date
    ) {
        return packageListingService.getFilteredPackages(Destination, creation_date, numberTravelers, freeCancellation,
                guidedTours, AirportTransfers, bundle_price, status, cancellation_date);

    }

    @GetMapping()
    public List<Package_Listing> getAllListings() {
        return packageListingService.getAllListings();
    }
}



