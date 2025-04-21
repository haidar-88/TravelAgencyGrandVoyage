package grandvoyage.software.project.domain;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "PACKAGE_LISTING")
public class Package_Listing {

    public Package_Listing(int package_id, List<Package_Booking> booked, List<Travel_Listing> travel, List<Accommodation_Listing> accommodation, List<Payment> payments, Date creation_date, Integer numberTravelers, Boolean freeCancellation, Boolean guidedTours, Boolean airportTransfers, Float bundle_price, String status, Date cancellation_date) {
        this.package_id = package_id;
        this.booked = booked;
        this.travel = travel;
        this.accommodation = accommodation;
        this.payments = payments;
        this.creation_date = creation_date;
        this.numberTravelers = numberTravelers;
        this.freeCancellation = freeCancellation;
        this.guidedTours = guidedTours;
        this.AirportTransfers = airportTransfers;
        this.bundle_price = bundle_price;
        this.status = status;
        this.cancellation_date = cancellation_date;
    }

    public Package_Listing() {}

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

    public int getPackage_id() {
        return package_id;
    }

    public void setPackage_id(int package_id) {
        this.package_id = package_id;
    }

    public List<Package_Booking> getBooked() {
        return booked;
    }

    public void setBooked(List<Package_Booking> booked) {
        this.booked = booked;
    }

    public List<Travel_Listing> getTravel() {
        return travel;
    }

    public void setTravel(List<Travel_Listing> travel) {
        this.travel = travel;
    }

    public List<Accommodation_Listing> getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(List<Accommodation_Listing> accommodation) {
        this.accommodation = accommodation;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public Integer getNumberTravelers() {
        return numberTravelers;
    }

    public void setNumberTravelers(Integer numberTravelers) {
        this.numberTravelers = numberTravelers;
    }

    public Boolean getFreeCancellation() {
        return freeCancellation;
    }

    public void setFreeCancellation(Boolean freeCancellation) {
        this.freeCancellation = freeCancellation;
    }

    public Boolean getGuidedTours() {
        return guidedTours;
    }

    public void setGuidedTours(Boolean guidedTours) {
        this.guidedTours = guidedTours;
    }

    public Boolean getAirportTransfers() {
        return AirportTransfers;
    }

    public void setAirportTransfers(Boolean airportTransfers) {
        AirportTransfers = airportTransfers;
    }

    public Float getBundle_price() {
        return bundle_price;
    }

    public void setBundle_price(Float bundle_price) {
        this.bundle_price = bundle_price;
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
