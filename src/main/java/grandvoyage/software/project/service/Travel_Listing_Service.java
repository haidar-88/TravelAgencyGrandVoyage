package grandvoyage.software.project.service;

import grandvoyage.software.project.domain.Cruise_Detail;
import grandvoyage.software.project.domain.Flight_Detail;
import grandvoyage.software.project.domain.Travel_Listing;
import grandvoyage.software.project.repository.CruiseDetailRepository;
import grandvoyage.software.project.repository.FlightDetailRepository;
import grandvoyage.software.project.repository.TravelListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
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


    public ResponseEntity<String> updateFlightListing(int id, Flight_Detail updateFlight,
                                                      Travel_Listing updateTravelListing) {
        Travel_Listing travelListingToUpdate = travelListingRepository.getReferenceById(id);

        Flight_Detail flightDetailToUpdate = travelListingToUpdate.getFlight();

        if (updateFlight.getAirline_name() != null) {
            flightDetailToUpdate.setAirline_name(updateFlight.getAirline_name());
        }
        if (updateFlight.getDeparture_airport() != null) {
            flightDetailToUpdate.setDeparture_airport(updateFlight.getDeparture_airport());
        }
        if (updateFlight.getArrival_airport() != null) {
            flightDetailToUpdate.setArrival_airport(updateFlight.getArrival_airport());
        }
        if (updateFlight.getFlight_number() != null) {
            flightDetailToUpdate.setFlight_number(updateFlight.getFlight_number());
        }
        if (updateFlight.getDeparture_terminal() != null) {
            flightDetailToUpdate.setDeparture_terminal(updateFlight.getDeparture_terminal());
        }
        if (updateFlight.getArrival_terminal() != null) {
            flightDetailToUpdate.setArrival_terminal(updateFlight.getArrival_terminal());
        }
        if (updateFlight.getDeparture_gate() != null) {
            flightDetailToUpdate.setDeparture_gate(updateFlight.getDeparture_gate());
        }
        if(updateFlight.getArrival_gate() != null) {
            flightDetailToUpdate.setArrival_gate(updateFlight.getArrival_gate());
        }
        if (updateFlight.getFlight_duration() != null) {
            flightDetailToUpdate.setFlight_duration(updateFlight.getFlight_duration());
        }
        if (updateFlight.getCabin_class() != null) {
            flightDetailToUpdate.setCabin_class(updateFlight.getCabin_class());
        }
        if (updateFlight.getBaggage_allowance() != null) {
            flightDetailToUpdate.setBaggage_allowance(updateFlight.getBaggage_allowance());
        }
        if (updateFlight.getMeal_included() != null) {
            flightDetailToUpdate.setMeal_included(updateFlight.getMeal_included());
        }

        if (updateTravelListing.getPosted_on_date() != null) {
            travelListingToUpdate.setPosted_on_date(updateTravelListing.getPosted_on_date());
        }
        if (updateTravelListing.getOriginal_price() != null) {
            travelListingToUpdate.setOriginal_price(updateTravelListing.getOriginal_price());
        }
        if (updateTravelListing.getIs_discounted() != null) {
            travelListingToUpdate.setIs_discounted(updateTravelListing.getIs_discounted());
        }
        if (updateTravelListing.getDiscounted_price() != null) {
            travelListingToUpdate.setDiscounted_price(updateTravelListing.getDiscounted_price());
        }
        if (updateTravelListing.getStatus() != null) {
            travelListingToUpdate.setStatus(updateTravelListing.getStatus());
        }
        if (updateTravelListing.getCancellation_date() != null) {
            travelListingToUpdate.setCancellation_date(updateTravelListing.getCancellation_date());
        }

        try {
            Flight_Detail updatedDetail = flightDetailRepository.save(flightDetailToUpdate);
            Travel_Listing updatedListing = travelListingRepository.save(travelListingToUpdate);

            return ResponseEntity.ok("Update successful");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to update: " + e.getMessage());
        }
    }

    public ResponseEntity<String> updateCruiseListing(int id, Cruise_Detail updateCruise,
                                                      Travel_Listing updateTravelListing) {
        Travel_Listing travelListingToUpdate = travelListingRepository.getReferenceById(id);

        Cruise_Detail cruiseDetailToUpdate = travelListingToUpdate.getCruise();

        if (updateCruise.getCruise_ship_name() != null) {
            cruiseDetailToUpdate.setCruise_ship_name(updateCruise.getCruise_ship_name());
        }
        if (updateCruise.getDeparture_port() != null) {
            cruiseDetailToUpdate.setDeparture_port(updateCruise.getDeparture_port());
        }
        if (updateCruise.getArrival_port() != null) {
            cruiseDetailToUpdate.setArrival_port(updateCruise.getArrival_port());
        }
        if (updateCruise.getEmbarkation_date() != null) {
            cruiseDetailToUpdate.setEmbarkation_date(updateCruise.getEmbarkation_date());
        }
        if (updateCruise.getDisembarkation_date() != null) {
            cruiseDetailToUpdate.setDisembarkation_date(updateCruise.getDisembarkation_date());
        }
        if (updateCruise.getNumber_of_nights() != null) {
            cruiseDetailToUpdate.setNumber_of_nights(updateCruise.getNumber_of_nights());
        }
        if (updateCruise.getCabin_type() != null) {
            cruiseDetailToUpdate.setCabin_type(updateCruise.getCabin_type());
        }

        if (updateTravelListing.getPosted_on_date() != null) {
            travelListingToUpdate.setPosted_on_date(updateTravelListing.getPosted_on_date());
        }
        if (updateTravelListing.getOriginal_price() != null) {
            travelListingToUpdate.setOriginal_price(updateTravelListing.getOriginal_price());
        }
        if (updateTravelListing.getIs_discounted() != null) {
            travelListingToUpdate.setIs_discounted(updateTravelListing.getIs_discounted());
        }
        if (updateTravelListing.getDiscounted_price() != null) {
            travelListingToUpdate.setDiscounted_price(updateTravelListing.getDiscounted_price());
        }
        if (updateTravelListing.getStatus() != null) {
            travelListingToUpdate.setStatus(updateTravelListing.getStatus());
        }
        if (updateTravelListing.getCancellation_date() != null) {
            travelListingToUpdate.setCancellation_date(updateTravelListing.getCancellation_date());
        }

        try {
            Cruise_Detail updatedDetail = cruiseDetailRepository.save(cruiseDetailToUpdate);
            Travel_Listing updatedListing = travelListingRepository.save(travelListingToUpdate);

            return ResponseEntity.ok("Update successful");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to update: " + e.getMessage());
        }

    }

    public boolean deleteFlight(int id) {
        if (flightDetailRepository.existsById(id)) {
            flightDetailRepository.deleteById(id);
            travelListingRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean deleteCruise(int id) {
        if (cruiseDetailRepository.existsById(id)) {
            cruiseDetailRepository.deleteById(id);
            travelListingRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Travel_Listing save(Travel_Listing travelListing) {
        return travelListingRepository.save(travelListing);
    }
}