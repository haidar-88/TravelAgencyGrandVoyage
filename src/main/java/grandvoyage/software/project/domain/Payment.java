package grandvoyage.software.project.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PAYMENT")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int payment_id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "package_id")
    private Package_Listing packageListing;

    @ManyToOne
    @JoinColumn(name = "travel_listing_id")
    private Travel_Listing TravelListing;

    @ManyToOne
    @JoinColumn(name = "accommodation_listing_id")
    private Accommodation_Listing accommodationListing;


    private String payment_method;
    private String card_number;
    private Date transaction_date;
    private double amount_paid;
    private String currency;
    private String payment_status;
    private boolean is_refunded;
    private Date refund_date;
}
