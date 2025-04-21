package grandvoyage.software.project.domain;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;


@Entity
@Table(name = "ACCOMMODATION_LISTING")
public class Accommodation_Listing {

    public Accommodation_Listing() {}

    public Accommodation_Listing(int accommodation_listing_id, Contract contract, List<Accommodation_Booking> bookings, List<Accommodation_Meals> meals, List<Package_Listing> package_listings, List<Payment> payments, String accommodation_name, String accommodation_type, Integer star_rating, Boolean single, Boolean double_, Boolean suite, Double original_price_per_night, Boolean gym, Boolean pool, Boolean wifi, Date posted_on_date, Boolean is_discounted, Double discounted_price_per_night, String address_name, String description, Integer max_number_of_travelers, String status, Date cancellation_date) {
        this.accommodation_listing_id = accommodation_listing_id;
        this.contract = contract;
        this.bookings = bookings;
        this.meals = meals;
        this.package_listings = package_listings;
        this.payments = payments;
        this.accommodation_name = accommodation_name;
        this.accommodation_type = accommodation_type;
        this.star_rating = star_rating;
        this.single = single;
        this.double_ = double_;
        this.suite = suite;
        this.original_price_per_night = original_price_per_night;
        this.gym = gym;
        this.pool = pool;
        this.wifi = wifi;
        this.posted_on_date = posted_on_date;
        this.is_discounted = is_discounted;
        this.discounted_price_per_night = discounted_price_per_night;
        this.address_name = address_name;
        this.description = description;
        this.max_number_of_travelers = max_number_of_travelers;
        this.status = status;
        this.cancellation_date = cancellation_date;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accommodation_listing_id;

    @ManyToOne
    @JoinColumn(name = "contract_id", nullable = false)
    private Contract contract;

    @OneToMany(mappedBy = "accommodation_listing")
    private List<Accommodation_Booking> bookings;

    @OneToMany(mappedBy = "accommodationListing")
    private List<Accommodation_Meals> meals;

    @ManyToMany(mappedBy = "accommodation")
    private List<Package_Listing> package_listings;

    @OneToMany(mappedBy = "accommodationListing")
    private List<Payment> payments;



    private String accommodation_name;
    private String accommodation_type;
    private Integer star_rating;
    private Boolean single;
    private Boolean double_;
    private Boolean suite;
    private Double original_price_per_night;
    private Boolean gym, pool, wifi;

    private Date posted_on_date;
    private Boolean is_discounted;
    private Double discounted_price_per_night;
    private String address_name;
    private String description;
    private Integer max_number_of_travelers;
    private String status;
    private Date cancellation_date;

    public int getAccommodation_listing_id() {
        return accommodation_listing_id;
    }

    public void setAccommodation_listing_id(int accommodation_listing_id) {
        this.accommodation_listing_id = accommodation_listing_id;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public List<Accommodation_Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Accommodation_Booking> bookings) {
        this.bookings = bookings;
    }

    public List<Accommodation_Meals> getMeals() {
        return meals;
    }

    public void setMeals(List<Accommodation_Meals> meals) {
        this.meals = meals;
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

    public String getAccommodation_name() {
        return accommodation_name;
    }

    public void setAccommodation_name(String accommodation_name) {
        this.accommodation_name = accommodation_name;
    }

    public String getAccommodation_type() {
        return accommodation_type;
    }

    public void setAccommodation_type(String accommodation_type) {
        this.accommodation_type = accommodation_type;
    }

    public Integer getStar_rating() {
        return star_rating;
    }

    public void setStar_rating(Integer star_rating) {
        this.star_rating = star_rating;
    }

    public Boolean getSingle() {
        return single;
    }

    public void setSingle(Boolean single) {
        this.single = single;
    }

    public Boolean getDouble_() {
        return double_;
    }

    public void setDouble_(Boolean double_) {
        this.double_ = double_;
    }

    public Boolean getSuite() {
        return suite;
    }

    public void setSuite(Boolean suite) {
        this.suite = suite;
    }

    public Double getOriginal_price_per_night() {
        return original_price_per_night;
    }

    public void setOriginal_price_per_night(Double original_price_per_night) {
        this.original_price_per_night = original_price_per_night;
    }

    public Boolean getGym() {
        return gym;
    }

    public void setGym(Boolean gym) {
        this.gym = gym;
    }

    public Boolean getPool() {
        return pool;
    }

    public void setPool(Boolean pool) {
        this.pool = pool;
    }

    public Boolean getWifi() {
        return wifi;
    }

    public void setWifi(Boolean wifi) {
        this.wifi = wifi;
    }

    public Date getPosted_on_date() {
        return posted_on_date;
    }

    public void setPosted_on_date(Date posted_on_date) {
        this.posted_on_date = posted_on_date;
    }

    public Boolean getIs_discounted() {
        return is_discounted;
    }

    public void setIs_discounted(Boolean is_discounted) {
        this.is_discounted = is_discounted;
    }

    public Double getDiscounted_price_per_night() {
        return discounted_price_per_night;
    }

    public void setDiscounted_price_per_night(Double discounted_price_per_night) {
        this.discounted_price_per_night = discounted_price_per_night;
    }

    public String getAddress_name() {
        return address_name;
    }

    public void setAddress_name(String address_name) {
        this.address_name = address_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getMax_number_of_travelers() {
        return max_number_of_travelers;
    }

    public void setMax_number_of_travelers(Integer max_number_of_travelers) {
        this.max_number_of_travelers = max_number_of_travelers;
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
