package grandvoyage.software.project.service;

import grandvoyage.software.project.domain.Accommodation_Listing;
import grandvoyage.software.project.repository.AccommodationListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
