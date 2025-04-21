package grandvoyage.software.project.domain;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "REVIEW")
public class Review {

    public Review(){}

    public Review(int review_id, Customer customer, String type_of_review, String review_heading, String review_body, boolean would_you_recommend, double star_rating, Date review_date) {
        this.review_id = review_id;
        this.customer = customer;
        this.type_of_review = type_of_review;
        this.review_heading = review_heading;
        this.review_body = review_body;
        this.would_you_recommend = would_you_recommend;
        this.star_rating = star_rating;
        this.review_date = review_date;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int review_id; // Unique identifier for each review

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer; // Links the review to the customer who submitted it

    private String type_of_review; // Specifies whether the review is for travel, accommodation, or package services
    private String review_heading; // Heading of the review
    private String review_body; // Detailed review content
    private boolean would_you_recommend; // Indicates if the reviewer would recommend the service
    private double star_rating; // Numerical score representing customer satisfaction
    private Date review_date; // Submission date of the review

    public int getReview_id() {
        return review_id;
    }

    public void setReview_id(int review_id) {
        this.review_id = review_id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getType_of_review() {
        return type_of_review;
    }

    public void setType_of_review(String type_of_review) {
        this.type_of_review = type_of_review;
    }

    public String getReview_heading() {
        return review_heading;
    }

    public void setReview_heading(String review_heading) {
        this.review_heading = review_heading;
    }

    public String getReview_body() {
        return review_body;
    }

    public void setReview_body(String review_body) {
        this.review_body = review_body;
    }

    public boolean isWould_you_recommend() {
        return would_you_recommend;
    }

    public void setWould_you_recommend(boolean would_you_recommend) {
        this.would_you_recommend = would_you_recommend;
    }

    public double getStar_rating() {
        return star_rating;
    }

    public void setStar_rating(double star_rating) {
        this.star_rating = star_rating;
    }

    public Date getReview_date() {
        return review_date;
    }

    public void setReview_date(Date review_date) {
        this.review_date = review_date;
    }
}
