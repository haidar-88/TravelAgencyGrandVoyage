package grandvoyage.software.project.controller.UserViewsModule;

import grandvoyage.software.project.domain.Accommodation_Listing;
import grandvoyage.software.project.service.Accommodation_Listing_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/accommodationListing")
public class Accommodation_Listing_Controller {

    private final Accommodation_Listing_Service accommodationListingService;

    @Autowired
    public Accommodation_Listing_Controller(Accommodation_Listing_Service accommodationListingService) {
        this.accommodationListingService = accommodationListingService;
    }

    @GetMapping
    public List<Accommodation_Listing> getAccommodationListings() {
        return accommodationListingService.getAllAccommodationListings();
    }

    @GetMapping("/filtered")
    public List<Accommodation_Listing> getFilteredAccommodationListings(@RequestParam String accommodationName,
                                                                        @RequestParam String accommodationType,
                                                                        @RequestParam Integer starRating,
                                                                        @RequestParam Boolean single,
                                                                        @RequestParam Boolean double_,
                                                                        @RequestParam Boolean suite,
                                                                        @RequestParam Double minPrice,
                                                                        @RequestParam Double maxPrice,
                                                                        @RequestParam Boolean gym,
                                                                        @RequestParam Boolean pool,
                                                                        @RequestParam Boolean wifi){
        return accommodationListingService.getFilteredAccommodationListings(accommodationName,accommodationType,
                starRating, single, double_, suite, minPrice, maxPrice, gym, pool, wifi);
    }

}



