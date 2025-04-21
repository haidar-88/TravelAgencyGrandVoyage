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
@Table(name = "TRAVEL_LISTING")
public class Travel_Listing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int travel_listing_id;

    @ManyToOne
    @JoinColumn(name = "related_contract_id", nullable = false)
    private Contract contract;

    @OneToMany(mappedBy = "travel_listing")
    private List<Travel_Booking> bookings;

    @OneToOne(mappedBy = "cruise_listing_id")
    private Cruise_Detail cruise;

    @OneToOne(mappedBy = "flight_listing_id")
    private Flight_Detail flight;

    @ManyToMany(mappedBy = "travel")
    private List<Package_Listing> package_listings;

    @OneToMany(mappedBy = "TravelListing")
    private List<Payment> payments;

    private Date posted_on_date;
    private Double original_price;
    private Boolean is_discounted;
    private Double discounted_price;
    private String status;
    private Date cancellation_date;
}
