package grandvoyage.software.project.domain;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

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

    @OneToOne
    @JoinColumn(name = "cruise_listing_id") // This column will be in the Travel_Listing table
    private Cruise_Detail cruise;


    @OneToOne
    @JoinColumn(name = "flight_listing_id")
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

    public int getTravel_listing_id() {
        return travel_listing_id;
    }

    public void setTravel_listing_id(int travel_listing_id) {
        this.travel_listing_id = travel_listing_id;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public List<Travel_Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Travel_Booking> bookings) {
        this.bookings = bookings;
    }

    public Cruise_Detail getCruise() {
        return cruise;
    }

    public void setCruise(Cruise_Detail cruise) {
        this.cruise = cruise;
    }

    public Flight_Detail getFlight() {
        return flight;
    }

    public void setFlight(Flight_Detail flight) {
        this.flight = flight;
    }

    public List<Package_Listing> getPackage_listings() {
        return package_listings;
    }

    public void setPackage_listings(List<Package_Listing> package_listings) {
        this.package_listings = package_listings;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public Date getPosted_on_date() {
        return posted_on_date;
    }

    public void setPosted_on_date(Date posted_on_date) {
        this.posted_on_date = posted_on_date;
    }

    public Double getOriginal_price() {
        return original_price;
    }

    public void setOriginal_price(Double original_price) {
        this.original_price = original_price;
    }

    public Boolean getIs_discounted() {
        return is_discounted;
    }

    public void setIs_discounted(Boolean is_discounted) {
        this.is_discounted = is_discounted;
    }

    public Double getDiscounted_price() {
        return discounted_price;
    }

    public void setDiscounted_price(Double discounted_price) {
        this.discounted_price = discounted_price;
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
}
