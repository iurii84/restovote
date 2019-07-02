package model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;
@Entity
@Table(name = "restaurants")
public class Restaurant {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;                                    //ID

    @Column(name = "name", nullable = false)
    @NotBlank
    @Size(min = 5, max = 30)
    private String name;                                //name of restaurant


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "meal_id", nullable = false)
    private List<Meal> mealList;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    private List<User> listOfUsersVotedFor;
}
