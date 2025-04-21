package grandvoyage.software.project.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "FLIGHT_LAYOVER")
public class Flight_Layover {

    public Flight_Layover(){}

    public Flight_Layover(int layover_id, Flight_Detail flight, String layover_airport_name, String start_time, String end_time) {
        this.layover_id = layover_id;
        this.flight = flight;
        this.layover_airport_name = layover_airport_name;
        this.start_time = start_time;
        this.end_time = end_time;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int layover_id;

    @ManyToOne
    @JoinColumn(name = "flight_listing_id")
    private Flight_Detail flight;

    private String layover_airport_name;
    private String start_time, end_time;

    public int getLayover_id() {
        return layover_id;
    }

    public void setLayover_id(int layover_id) {
        this.layover_id = layover_id;
    }

    public Flight_Detail getFlight() {
        return flight;
    }

    public void setFlight(Flight_Detail flight) {
        this.flight = flight;
    }

    public String getLayover_airport_name() {
        return layover_airport_name;
    }

    public void setLayover_airport_name(String layover_airport_name) {
        this.layover_airport_name = layover_airport_name;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }
}
