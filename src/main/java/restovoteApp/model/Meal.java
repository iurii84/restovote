package restovoteApp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@SuppressWarnings("all")
@NamedQueries({
        @NamedQuery(name = Meal.DELETE, query = "DELETE FROM Meal m WHERE m.id=:id AND m.user.id=:userId"),
        @NamedQuery(name = Meal.GET_BY_ID, query = "SELECT m FROM Meal m WHERE m.id=:id"),
        @NamedQuery(name = Meal.GET_BY_RESTO_ID, query = "SELECT m FROM Meal m WHERE m.restaurant.id=:restoid")
})

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "meals")
public class Meal {
    public static final String DELETE = "Meal.delete";
    public static final String GET_BY_ID = "Meal.getById";
    public static final String GET_BY_RESTO_ID = "Meal.getByRestoId";


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                                        //ID

    @Column(name = "description", nullable = false)
    @NotBlank
    @Size(min = 5, max = 100)
    private String description;                             //Description of the meal

    @Column(name = "price", nullable = false)
    @NotNull
    @Range(max = 200_00)
    private Long price;                                     //price in cents (max price 200$)

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)                      //reference for the restaurants id, that proposes that meal
    @JoinColumn(name = "restoId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Restaurant restaurant;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;                                      //reference for the user's(admin's) id, whose added that restaurant

    public Meal() {
    }

    public Meal(Long id, @NotBlank @Size(min = 5, max = 100) String description, @NotNull @Range(max = 200_00) Long price) {
        this.id = id;
        this.description = description;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isNew() {
        return this.id == null;
    }
}
