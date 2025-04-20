package grandvoyage.software.project.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ACCOMMODATION_LISTING")
public class Accommodation_Listing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accommodation_listing_id;

    @ManyToOne
    @JoinColumn(name = "contract_id", nullable = false)
    private Contract contract;

    @OneToMany(mappedBy = "accommodation_listing")
    private List<Accommodation_Booking> bookings;

    @OneToMany(mappedBy = "accommodationListing")
    private List<Accommodation_Meals> meals;

    @ManyToMany(mappedBy = "accommodation")
    private List<Package_Listing> package_listings;

    @OneToMany(mappedBy = "accommodationListing")
    private List<Payment> payments;



    private String accommodation_name;
    private String accommodation_type;
    private int star_rating;
    private boolean single;
    private boolean double_;
    private boolean suite;
    private double original_price_per_night;
    private boolean gym, pool, wifi;

    private Date posted_on_date;
    private boolean is_discounted;
    private double discounted_price_per_night;
    private String address_name;
    private String description;
    private int max_number_of_travelers;
    private String status;
    private Date cancellation_date;
}
