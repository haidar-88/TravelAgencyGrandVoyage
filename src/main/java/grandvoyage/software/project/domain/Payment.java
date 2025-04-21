package grandvoyage.software.project.domain;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "PAYMENT")
public class Payment {

    public Payment(){}

    public Payment(int payment_id, Customer customer, Package_Listing packageListing, Travel_Listing travelListing, Accommodation_Listing accommodationListing, String payment_method, String card_number, Date transaction_date, double amount_paid, String currency, String payment_status, boolean is_refunded, Date refund_date) {
        this.payment_id = payment_id;
        this.customer = customer;
        this.packageListing = packageListing;
        TravelListing = travelListing;
        this.accommodationListing = accommodationListing;
        this.payment_method = payment_method;
        this.card_number = card_number;
        this.transaction_date = transaction_date;
        this.amount_paid = amount_paid;
        this.currency = currency;
        this.payment_status = payment_status;
        this.is_refunded = is_refunded;
        this.refund_date = refund_date;
    }

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

    public int getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Package_Listing getPackageListing() {
        return packageListing;
    }

    public void setPackageListing(Package_Listing packageListing) {
        this.packageListing = packageListing;
    }

    public Travel_Listing getTravelListing() {
        return TravelListing;
    }

    public void setTravelListing(Travel_Listing travelListing) {
        TravelListing = travelListing;
    }

    public Accommodation_Listing getAccommodationListing() {
        return accommodationListing;
    }

    public void setAccommodationListing(Accommodation_Listing accommodationListing) {
        this.accommodationListing = accommodationListing;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    public Date getTransaction_date() {
        return transaction_date;
    }

    public void setTransaction_date(Date transaction_date) {
        this.transaction_date = transaction_date;
    }

    public double getAmount_paid() {
        return amount_paid;
    }

    public void setAmount_paid(double amount_paid) {
        this.amount_paid = amount_paid;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getPayment_status() {
        return payment_status;
    }

    public void setPayment_status(String payment_status) {
        this.payment_status = payment_status;
    }

    public boolean isIs_refunded() {
        return is_refunded;
    }

    public void setIs_refunded(boolean is_refunded) {
        this.is_refunded = is_refunded;
    }

    public Date getRefund_date() {
        return refund_date;
    }

    public void setRefund_date(Date refund_date) {
        this.refund_date = refund_date;
    }
}
