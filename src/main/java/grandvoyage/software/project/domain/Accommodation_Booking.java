package grandvoyage.software.project.domain;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "ACCOMMODATION_BOOKING")
public class Accommodation_Booking {

    public Accommodation_Booking() {}
    public Accommodation_Booking(Accommodation_Listing accommodation_listing, Customer customer, Payment payment, Review review) {
        this.accommodation_listing = accommodation_listing;
        this.customer = customer;
        this.payment = payment;
        this.review = review;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int booking_id;

    @ManyToOne
    @JoinColumn(name = "accommodation_listing_id", nullable = false)
    private Accommodation_Listing accommodation_listing;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;

    @OneToOne
    @JoinColumn(name = "review_id")
    private Review review;

    private Date booked_on;
    private String status;
    private Date cancellation_date;
    private boolean is_refunded;
    private Date refunding_date;

    public int getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(int booking_id) {
        this.booking_id = booking_id;
    }

    public Accommodation_Listing getAccommodation_listing() {
        return accommodation_listing;
    }

    public void setAccommodation_listing(Accommodation_Listing accommodation_listing) {
        this.accommodation_listing = accommodation_listing;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    public Date getBooked_on() {
        return booked_on;
    }

    public void setBooked_on(Date booked_on) {
        this.booked_on = booked_on;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCancellation_date() {
        return cancellation_date;
    }

    public void setCancellation_date(Date cancellation_date) {
        this.cancellation_date = cancellation_date;
    }

    public boolean isIs_refunded() {
        return is_refunded;
    }

    public void set_refunded(boolean is_refunded) {
        this.is_refunded = is_refunded;
    }

    public Date getRefunding_date() {
        return refunding_date;
    }

    public void setRefunding_date(Date refunding_date) {
        this.refunding_date = refunding_date;
    }

}
