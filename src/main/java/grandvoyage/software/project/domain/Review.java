package grandvoyage.software.project.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "REVIEW")
public class Review {

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
}
