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
@Table(name = "TRAVEL_BOOKING")
public class Travel_Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int booking_id;

    @ManyToOne
    @JoinColumn(name = "travel_listing_id")
    private Travel_Listing travel_listing;

    private Date booked_on_date;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    private String status;
    private Date cancellation_date;
    private boolean is_refunded;
    private Date refunding_date;

    @OneToOne
    @JoinColumn(name = "review_id")
    private Review review;

    @OneToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;

}
