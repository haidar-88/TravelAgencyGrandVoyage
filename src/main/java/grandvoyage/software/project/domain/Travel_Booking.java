package grandvoyage.software.project.domain;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "TRAVEL_BOOKING")
public class Travel_Booking {

    public Travel_Booking(){}
    public Travel_Booking(Travel_Listing travel_listing, Customer customer, Date booked_on_date, String status, Date cancellation_date, boolean is_refunded, Date refunding_date, Review review, Payment payment) {
        this.travel_listing = travel_listing;
        this.customer = customer;
        this.booked_on_date = booked_on_date;
        this.status = status;
        this.cancellation_date = cancellation_date;
        this.is_refunded = is_refunded;
    }

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

    public int getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(int booking_id) {
        this.booking_id = booking_id;
    }

    public Travel_Listing getTravel_listing() {
        return travel_listing;
    }

    public void setTravel_listing(Travel_Listing travel_listing) {
        this.travel_listing = travel_listing;
    }

    public Date getBooked_on_date() {
        return booked_on_date;
    }

    public void setBooked_on_date(Date booked_on_date) {
        this.booked_on_date = booked_on_date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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

    public boolean is_refunded() {
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

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

}
