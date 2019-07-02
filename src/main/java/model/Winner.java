package model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity                                                     //implementation for further statistics use.
@Table(name = "winners", uniqueConstraints = @UniqueConstraint(columnNames = {"localDate", "restaurant"})
                                                            //the pair of "date" and "restaurant" must be unique, so
                                                            //   just ONE winner per day.

)
public class Winner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)         //ID
    private Long id;


    @Column(name = "date", nullable = false)
    private LocalDate localDate;                            //Date when the restaurant become the winner

    @Column (name = "restaurant", nullable = false)
    private Restaurant restaurant;                          //get entire entity of restaurant. Even restaurant is removed
                                                            //we can see all statistics of voting

}
