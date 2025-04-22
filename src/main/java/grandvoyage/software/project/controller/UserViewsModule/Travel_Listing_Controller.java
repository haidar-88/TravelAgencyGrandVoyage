package grandvoyage.software.project.controller.UserViewsModule;

import grandvoyage.software.project.domain.Cruise_Detail;
import grandvoyage.software.project.domain.Flight_Detail;
import grandvoyage.software.project.domain.Flight_Layover;
import grandvoyage.software.project.domain.Travel_Listing;
import grandvoyage.software.project.service.Travel_Listing_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/travelListing")
public class Travel_Listing_Controller {

    @Autowired
    private final Travel_Listing_Service travelListingService;

    public Travel_Listing_Controller(Travel_Listing_Service travelListingService) {
        this.travelListingService = travelListingService;
    }

    @GetMapping("/flights")
    public List<Flight_Detail> getFilteredFlights(
            @RequestParam(required = false) String airline,
            @RequestParam(required = false) String departureAirport,
            @RequestParam(required = false) String arrivalAirport,
            @RequestParam(required = false) Integer minDuration,
            @RequestParam(required = false) Integer maxDuration,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(required = false) String cabinClass,
            @RequestParam(required = false) Integer baggageAllowance,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date departureDate,
            @RequestParam(required = false) Boolean mealsIncluded,
            @RequestParam(required = false) Boolean noLayover
    ) {
        return travelListingService.getFilteredFlights(airline, departureAirport, arrivalAirport, minDuration, maxDuration,
                minPrice, maxPrice, cabinClass, baggageAllowance,
                departureDate, mealsIncluded, noLayover);
    }

    @GetMapping("/cruises")
    public List<Cruise_Detail> getFilteredCruises(
            @RequestParam(required = false) String cruiseShipName,
            @RequestParam(required = false) String departurePort,
            @RequestParam(required = false) String arrivalPort,
            @RequestParam(required = false) Date startDate,
            @RequestParam(required = false) Date endDate,
            @RequestParam(required = false) Integer Duration,
            @RequestParam(required = false) String cabinType,
            @RequestParam(required = false) Boolean spa,
            @RequestParam(required = false) Boolean casino,
            @RequestParam(required = false) Boolean theater,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice
    ) {
        return travelListingService.getFilteredCruises(cruiseShipName, departurePort, arrivalPort,
                startDate, endDate, Duration, cabinType, spa, casino, theater, minPrice, maxPrice);
    }

    @GetMapping
    public List<Travel_Listing> getAllListings(){
        return travelListingService.getAllListings();
    }

}
