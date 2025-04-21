package grandvoyage.software.project.domain;

import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name = "PACKAGE_BOOKING")
public class Package_Booking {

    public Package_Booking(){}

    public Package_Booking(int booking_id, Package_Listing package_listing, Review review, Customer customer, Payment payment, Date booked_on_date, String status, Date cancellation_date, boolean is_refunded, Date refunding_date) {
        this.booking_id = booking_id;
        this.package_listing = package_listing;
        this.review = review;
        this.customer = customer;
        this.payment = payment;
        this.booked_on_date = booked_on_date;
        this.status = status;
        this.cancellation_date = cancellation_date;
        this.is_refunded = is_refunded;
        this.refunding_date = refunding_date;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int booking_id;

    @ManyToOne
    @JoinColumn(name = "package_listing_id", nullable = false)
    private Package_Listing package_listing;

    @OneToOne
    @JoinColumn(name = "review_id")
    private Review review;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;

    private Date booked_on_date;
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

    public Package_Listing getPackage_listing() {
        return package_listing;
    }

    public void setPackage_listing(Package_Listing package_listing) {
        this.package_listing = package_listing;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
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

    public Date getBooked_on_date() {
        return booked_on_date;
    }

    public void setBooked_on_date(Date booked_on_date) {
        this.booked_on_date = booked_on_date;
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
}
