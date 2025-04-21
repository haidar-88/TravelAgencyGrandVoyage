package grandvoyage.software.project.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "ACCOMMODATION_MEALS")
public class Accommodation_Meals {

    public Accommodation_Meals() {}

    public Accommodation_Meals(int id, String amenity_name, Accommodation_Listing accommodationListing) {
        this.id = id;
        this.amenity_name = amenity_name;
        this.accommodationListing = accommodationListing;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String amenity_name;

    @ManyToOne
    @JoinColumn(name = "accommodation_listing_id", nullable = false)
    private Accommodation_Listing accommodationListing;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAmenity_name() {
        return amenity_name;
    }

    public void setAmenity_name(String amenity_name) {
        this.amenity_name = amenity_name;
    }

    public Accommodation_Listing getAccommodationListing() {
        return accommodationListing;
    }

    public void setAccommodationListing(Accommodation_Listing accommodationListing) {
        this.accommodationListing = accommodationListing;
    }
}
