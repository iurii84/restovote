package model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "meals")
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;                                        //ID

    @Column(name = "description", nullable = false)
    @NotBlank
    @Size(min = 5, max = 100)
    private String description;                             //Description of the meal

    @Column(name = "price", nullable = false)
    @NotNull
    @Range(max = 200_00)
    private Long price;                                     //price in cents (max price 200$)

    @ManyToOne(fetch = FetchType.LAZY)                      //reference for the restaurants id, that proposes that meal
    @JoinColumn(name = "resto_id", referencedColumnName = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Restaurant restaurant;

}
