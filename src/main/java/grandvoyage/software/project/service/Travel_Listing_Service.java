package grandvoyage.software.project.service;

import grandvoyage.software.project.domain.Cruise_Detail;
import grandvoyage.software.project.domain.Flight_Detail;
import grandvoyage.software.project.domain.Travel_Listing;
import grandvoyage.software.project.repository.CruiseDetailRepository;
import grandvoyage.software.project.repository.FlightDetailRepository;
import grandvoyage.software.project.repository.TravelListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class Travel_Listing_Service {

    private final FlightDetailRepository flightDetailRepository;
    private final CruiseDetailRepository cruiseDetailRepository;
    private final TravelListingRepository travelListingRepository;

    @Autowired
    public Travel_Listing_Service(FlightDetailRepository flightDetailRepository, CruiseDetailRepository cruiseDetailRepository, TravelListingRepository travelListingRepository) {
        this.cruiseDetailRepository = cruiseDetailRepository;
        this.flightDetailRepository = flightDetailRepository;
        this.travelListingRepository = travelListingRepository;
    }

    public List<Flight_Detail> getFilteredFlights(String airline, String departureAirport, String arrivalAirport,
                                                  Integer minDuration, Integer maxDuration, Double minPrice, Double maxPrice,
                                                  String cabinClass, Integer baggageAllowance, Date departureDate,
                                                  Boolean mealsIncluded, Boolean noLayover) {
        return flightDetailRepository.getFilteredFlights(airline, departureAirport, arrivalAirport,
                minDuration, maxDuration, minPrice, maxPrice, cabinClass, baggageAllowance,
                departureDate, mealsIncluded, noLayover);
    }

    public List<Cruise_Detail> getFilteredCruises(String cruiseShipName, String departurePort, String arrivalPort,
                                                  Date startDate, Date endDate, Integer duration, String cabinType,
                                                  Boolean spa, Boolean casino, Boolean theater, Double minPrice,
                                                  Double maxPrice) {
        return cruiseDetailRepository.getFilteredCruises(cruiseShipName, departurePort, arrivalPort, startDate, endDate, duration
        , cabinType, spa, casino, theater, minPrice, maxPrice);
    }

    public List<Travel_Listing> getAllListings() {
        return travelListingRepository.findAll();
    }
}