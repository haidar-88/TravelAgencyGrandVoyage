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
@Table(name = "PACKAGE_LISTING")
public class Package_Listing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int package_id;

    @OneToMany(mappedBy = "package_listing")
    private List<Package_Booking> booked;

    @ManyToMany
    @JoinTable(
            name = "package_travel",
            joinColumns = @JoinColumn(name = "package_id"),
            inverseJoinColumns = @JoinColumn(name = "travel_listing_id")
    )
    private List<Travel_Listing> travel;

    @ManyToMany
    @JoinTable(
            name = "package_accommodation",
            joinColumns = @JoinColumn(name = "package_id"),
            inverseJoinColumns = @JoinColumn(name = "accommodation_listing_id")
    )
    private List<Accommodation_Listing> accommodation;

    @OneToMany(mappedBy = "packageListing")
    private List<Payment> payments;

    private Date creation_date;
    private Integer numberTravelers;
    private Boolean freeCancellation;
    private Boolean guidedTours;
    private Boolean AirportTransfers;
    private Float bundle_price;
    private String status;
    private Date cancellation_date;
}
