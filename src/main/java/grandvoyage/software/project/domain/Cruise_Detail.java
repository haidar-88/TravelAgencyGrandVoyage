package grandvoyage.software.project.domain;

import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name = "CRUISE_DETAIL")
public class Cruise_Detail {

    public Cruise_Detail(int cruise_listing_id, String cruise_ship_name, String departure_port, String arrival_port, Date embarkation_date, Date disembarkation_date, Integer number_of_nights, String cabin_type) {
        this.cruise_listing_id = cruise_listing_id;
        this.cruise_ship_name = cruise_ship_name;
        this.departure_port = departure_port;
        this.arrival_port = arrival_port;
        this.embarkation_date = embarkation_date;
        this.disembarkation_date = disembarkation_date;
        this.number_of_nights = number_of_nights;
        this.cabin_type = cabin_type;
    }

    public Cruise_Detail() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cruise_listing_id; // Unique ID for the cruise

    private String cruise_ship_name; // Name of the ship
    private String departure_port; // Location of embarkation
    private String arrival_port; // Location of disembarkation
    private Date embarkation_date; // Start of the trip
    private Date disembarkation_date; // End of the trip
    private Integer number_of_nights; // Total nights on the cruise
    private String cabin_type; // Room type on the ship
    private Boolean spa_available;
    private Boolean casino_available;
    private Boolean theater_available;

    @OneToOne(mappedBy = "cruise")
    private Travel_Listing travelListing;

    public int getCruise_listing_id() {
        return cruise_listing_id;
    }

    public void setCruise_listing_id(int cruise_listing_id) {
        this.cruise_listing_id = cruise_listing_id;
    }

    public String getCruise_ship_name() {
        return cruise_ship_name;
    }

    public void setCruise_ship_name(String cruise_ship_name) {
        this.cruise_ship_name = cruise_ship_name;
    }

    public String getDeparture_port() {
        return departure_port;
    }

    public void setDeparture_port(String departure_port) {
        this.departure_port = departure_port;
    }

    public String getArrival_port() {
        return arrival_port;
    }

    public void setArrival_port(String arrival_port) {
        this.arrival_port = arrival_port;
    }

    public Date getEmbarkation_date() {
        return embarkation_date;
    }

    public void setEmbarkation_date(Date embarkation_date) {
        this.embarkation_date = embarkation_date;
    }

    public Date getDisembarkation_date() {
        return disembarkation_date;
    }

    public void setDisembarkation_date(Date disembarkation_date) {
        this.disembarkation_date = disembarkation_date;
    }

    public Integer getNumber_of_nights() {
        return number_of_nights;
    }

    public void setNumber_of_nights(Integer number_of_nights) {
        this.number_of_nights = number_of_nights;
    }

    public String getCabin_type() {
        return cabin_type;
    }

    public void setCabin_type(String cabin_type) {
        this.cabin_type = cabin_type;
    }

    public Boolean getSpa_available() {
        return spa_available;
    }

    public void setSpa_available(Boolean spa_available) {
        this.spa_available = spa_available;
    }

    public Boolean getCasino_available() {
        return casino_available;
    }

    public void setCasino_available(Boolean casino_available) {
        this.casino_available = casino_available;
    }

    public Boolean getTheater_available() {
        return theater_available;
    }

    public void setTheater_available(Boolean theater_available) {
        this.theater_available = theater_available;
    }

    public Travel_Listing getTravelListing() {
        return travelListing;
    }

    public void setTravelListing(Travel_Listing travelListing) {
        this.travelListing = travelListing;
    }
}
