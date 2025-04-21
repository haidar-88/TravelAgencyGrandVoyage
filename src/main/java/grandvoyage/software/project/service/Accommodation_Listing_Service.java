package grandvoyage.software.project.service;

import grandvoyage.software.project.domain.Accommodation_Listing;
import grandvoyage.software.project.domain.Cruise_Detail;
import grandvoyage.software.project.domain.Travel_Listing;
import grandvoyage.software.project.repository.AccommodationListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class Accommodation_Listing_Service {

    private final AccommodationListingRepository accommodationListingRepository;

    @Autowired
    public Accommodation_Listing_Service(AccommodationListingRepository accommodationListingRepository) {
        this.accommodationListingRepository = accommodationListingRepository;
    }

    public List<Accommodation_Listing> getAllAccommodationListings() {
        return accommodationListingRepository.findAll();
    }

    public List<Accommodation_Listing> getFilteredAccommodationListings(String accommodationName, String accommodationType,
                                                                        Integer starRating, Boolean single,
                                                                        Boolean double_, Boolean suite,
                                                                        Double minPrice, Double maxPrice,
                                                                        Boolean gym, Boolean pool, Boolean wifi) {
        return accommodationListingRepository.findFilteredAccommodationListings(accommodationName, accommodationType, starRating,
                single, double_, suite, minPrice, maxPrice, gym, pool, wifi);
    }

    public ResponseEntity<String> updateAccommodationListing(int id, Accommodation_Listing updateAccommodation
                                                      ) {
        Accommodation_Listing accommodationListingToUpdate = accommodationListingRepository.getReferenceById(id);

        if (updateAccommodation.getAccommodation_name() != null) {
            accommodationListingToUpdate.setAccommodation_name(updateAccommodation.getAccommodation_name());
        }
        if (updateAccommodation.getAccommodation_type() != null) {
            accommodationListingToUpdate.setAccommodation_type(updateAccommodation.getAccommodation_type());
        }
        if (updateAccommodation.getStar_rating() != null) {
            accommodationListingToUpdate.setStar_rating(updateAccommodation.getStar_rating());
        }
        if (updateAccommodation.getSingle() != null) {
            accommodationListingToUpdate.setSingle(updateAccommodation.getSingle());
        }
        if (updateAccommodation.getDouble_() != null) {
            accommodationListingToUpdate.setDouble_(updateAccommodation.getDouble_());
        }
        if (updateAccommodation.getSuite() != null) {
            accommodationListingToUpdate.setSuite(updateAccommodation.getSuite());
        }
        if (updateAccommodation.getOriginal_price_per_night() != null) {
            accommodationListingToUpdate.setOriginal_price_per_night(updateAccommodation.getOriginal_price_per_night());
        }
        if (updateAccommodation.getGym() != null) {
            accommodationListingToUpdate.setGym(updateAccommodation.getGym());
        }
        if (updateAccommodation.getPool() != null) {
            accommodationListingToUpdate.setPool(updateAccommodation.getPool());
        }
        if (updateAccommodation.getWifi() != null) {
            accommodationListingToUpdate.setWifi(updateAccommodation.getWifi());
        }
        if (updateAccommodation.getPosted_on_date() != null) {
            accommodationListingToUpdate.setPosted_on_date(updateAccommodation.getPosted_on_date());
        }
        if (updateAccommodation.getIs_discounted() != null) {
            accommodationListingToUpdate.setIs_discounted(updateAccommodation.getIs_discounted());
        }
        if (updateAccommodation.getDiscounted_price_per_night() != null) {
            accommodationListingToUpdate.setDiscounted_price_per_night(updateAccommodation.getDiscounted_price_per_night());
        }
        if (updateAccommodation.getAddress_name() != null) {
            accommodationListingToUpdate.setAddress_name(updateAccommodation.getAddress_name());
        }
        if (updateAccommodation.getDescription() != null) {
            accommodationListingToUpdate.setDescription(updateAccommodation.getDescription());
        }
        if (updateAccommodation.getMax_number_of_travelers() != null) {
            accommodationListingToUpdate.setMax_number_of_travelers(updateAccommodation.getMax_number_of_travelers());
        }
        if (updateAccommodation.getStatus() != null) {
            accommodationListingToUpdate.setStatus(updateAccommodation.getStatus());
        }
        if (updateAccommodation.getCancellation_date() != null) {
            accommodationListingToUpdate.setCancellation_date(updateAccommodation.getCancellation_date());
        }

        try {
            Accommodation_Listing updatedAccommodation = accommodationListingRepository.save(accommodationListingToUpdate);
            return ResponseEntity.ok("Update successful");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to update: " + e.getMessage());
        }

    }

    public boolean deleteAccommodationListing(int id) {
        if (accommodationListingRepository.existsById(id)) {
            accommodationListingRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
