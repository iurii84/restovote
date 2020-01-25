package restovote.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@NamedQueries({
        @NamedQuery(name = Restaurant.GET_BY_ID, query = "SELECT r FROM Restaurant r WHERE r.id=:id"),
        @NamedQuery(name = Restaurant.DELETE_BY_ID, query = "DELETE FROM Restaurant r WHERE r.id=:id AND r.createdBy.id=:userId"),
        @NamedQuery(name = Restaurant.GET_ALL, query = "SELECT r FROM Restaurant r")
})


@Entity
@Table(name = "restaurants")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Restaurant {
    public static final String GET_BY_ID = "Restaurant.getById";
    public static final String DELETE_BY_ID = "Restaurant.deleteById";
    public static final String GET_ALL = "Restaurant.getAll";

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;                                    //ID

    @Column(name = "name", nullable = false)
    @NotBlank
    @Size(min = 5, max = 30)
    private String name;                                //name of restaurant


    @JsonIgnore
    @OneToMany(mappedBy = "id", fetch = FetchType.EAGER)
    private List<Meal> mealList;


    @JsonIgnore
    @OneToMany(mappedBy = "id")
    private List<User> listOfUsersVotedFor;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "createdBy")
    private User createdBy;


    public Restaurant() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Meal> getMealList() {
        return mealList;
    }

    public void setMealList(List<Meal> mealList) {
        this.mealList = mealList;
    }

    public List<User> getListOfUsersVotedFor() {
        return listOfUsersVotedFor;
    }

    public void setListOfUsersVotedFor(List<User> listOfUsersVotedFor) {
        this.listOfUsersVotedFor = listOfUsersVotedFor;
    }

    public boolean isNew() {
        return this.id == null;
    }



    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }
}
