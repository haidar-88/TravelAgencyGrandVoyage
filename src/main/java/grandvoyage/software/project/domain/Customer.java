package grandvoyage.software.project.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;


@Entity
@Table(name = "CUSTOMER")
public class Customer {

    public Customer() {}

    public Customer(int customer_id, List<Package_Booking> package_bookings, List<Travel_Booking> travel_bookings, List<Accommodation_Booking> accommodation_bookings, String username, String first_name, String last_name, int phone_number, String email, String password, String address, Date registration_date, char gender, String nationality) {
        this.customer_id = customer_id;
        this.package_bookings = package_bookings;
        this.travel_bookings = travel_bookings;
        this.accommodation_bookings = accommodation_bookings;
        this.username = username;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_number = phone_number;
        this.email = email;
        this.password = password;
        this.address = address;
        this.registration_date = registration_date;
        this.gender = gender;
        this.nationality = nationality;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customer_id;

    @OneToMany(mappedBy = "customer")
    private List<Package_Booking> package_bookings;

    @OneToMany(mappedBy = "customer")
    private List<Travel_Booking> travel_bookings;

    @OneToMany(mappedBy = "customer")
    private List<Accommodation_Booking> accommodation_bookings;

    private String username;
    private String first_name, last_name;
    private int phone_number;
    private String email;
    private String password;
    private String address;
    private Date registration_date;
    private char gender;
    private String nationality;

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public List<Package_Booking> getPackage_bookings() {
        return package_bookings;
    }

    public void setPackage_bookings(List<Package_Booking> package_bookings) {
        this.package_bookings = package_bookings;
    }

    public List<Travel_Booking> getTravel_bookings() {
        return travel_bookings;
    }

    public void setTravel_bookings(List<Travel_Booking> travel_bookings) {
        this.travel_bookings = travel_bookings;
    }

    public List<Accommodation_Booking> getAccommodation_bookings() {
        return accommodation_bookings;
    }

    public void setAccommodation_bookings(List<Accommodation_Booking> accommodation_bookings) {
        this.accommodation_bookings = accommodation_bookings;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(Date registration_date) {
        this.registration_date = registration_date;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
