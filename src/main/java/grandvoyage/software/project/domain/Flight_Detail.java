package grandvoyage.software.project.domain;

import jakarta.persistence.*;

import java.util.List;
import java.util.Date;

@Entity
@Table(name = "FLIGHT_DETAIL")
public class Flight_Detail {

    public Flight_Detail(Date departure_date,int flight_listing_id, List<Flight_Layover> layovers,
                         String airline_name, Integer flight_number, String departure_airport,
                         String arrival_airport, String departure_terminal, String arrival_terminal,
                         String departure_gate, String arrival_gate, Integer flight_duration,
                         String cabin_class, Integer baggage_allowance, Boolean meal_included) {

        this.flight_listing_id = flight_listing_id;
        this.layovers = layovers;
        this.airline_name = airline_name;
        this.flight_number = flight_number;
        this.departure_airport = departure_airport;
        this.arrival_airport = arrival_airport;
        this.departure_terminal = departure_terminal;
        this.arrival_terminal = arrival_terminal;
        this.departure_gate = departure_gate;
        this.arrival_gate = arrival_gate;
        this.flight_duration = flight_duration;
        this.cabin_class = cabin_class;
        this.baggage_allowance = baggage_allowance;
        this.meal_included = meal_included;
        this.departure_date = departure_date;
    }

    public Flight_Detail() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int flight_listing_id;

    private String airline_name;
    private Integer flight_number;
    private String departure_airport, arrival_airport;
    private String departure_terminal, arrival_terminal;
    private String departure_gate, arrival_gate;
    private Integer flight_duration;
    private String cabin_class;
    private Integer baggage_allowance;
    private Boolean meal_included;
    private Date departure_date;

    @OneToMany(mappedBy = "flight")
    private List<Flight_Layover> layovers;

    @OneToOne(mappedBy = "flight")
    private Travel_Listing travelListing;

    public Date getDeparture_date() { return departure_date;}

    public Date setDeparture_date(Date departure_date) { return this.departure_date = departure_date;}

    public int getFlight_listing_id() {
        return flight_listing_id;
    }

    public void setFlight_listing_id(int flight_listing_id) {
        this.flight_listing_id = flight_listing_id;
    }

    public List<Flight_Layover> getLayovers() {
        return layovers;
    }

    public void setLayovers(List<Flight_Layover> layovers) {
        this.layovers = layovers;
    }

    public String getAirline_name() {
        return airline_name;
    }

    public void setAirline_name(String airline_name) {
        this.airline_name = airline_name;
    }

    public Integer getFlight_number() {
        return flight_number;
    }

    public void setFlight_number(Integer flight_number) {
        this.flight_number = flight_number;
    }

    public String getDeparture_airport() {
        return departure_airport;
    }

    public void setDeparture_airport(String departure_airport) {
        this.departure_airport = departure_airport;
    }

    public String getArrival_airport() {
        return arrival_airport;
    }

    public void setArrival_airport(String arrival_airport) {
        this.arrival_airport = arrival_airport;
    }

    public String getDeparture_terminal() {
        return departure_terminal;
    }

    public void setDeparture_terminal(String departure_terminal) {
        this.departure_terminal = departure_terminal;
    }

    public String getArrival_terminal() {
        return arrival_terminal;
    }

    public void setArrival_terminal(String arrival_terminal) {
        this.arrival_terminal = arrival_terminal;
    }

    public String getDeparture_gate() {
        return departure_gate;
    }

    public void setDeparture_gate(String departure_gate) {
        this.departure_gate = departure_gate;
    }

    public String getArrival_gate() {
        return arrival_gate;
    }

    public void setArrival_gate(String arrival_gate) {
        this.arrival_gate = arrival_gate;
    }

    public Integer getFlight_duration() {
        return flight_duration;
    }

    public void setFlight_duration(Integer flight_duration) {
        this.flight_duration = flight_duration;
    }

    public String getCabin_class() {
        return cabin_class;
    }

    public void setCabin_class(String cabin_class) {
        this.cabin_class = cabin_class;
    }

    public Integer getBaggage_allowance() {
        return baggage_allowance;
    }

    public void setBaggage_allowance(Integer baggage_allowance) {
        this.baggage_allowance = baggage_allowance;
    }

    public Boolean getMeal_included() {
        return meal_included;
    }

    public void setMeal_included(Boolean meal_included) {
        this.meal_included = meal_included;
    }
}
