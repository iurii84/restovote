package restovoteApp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Set;

@NamedQueries({
        @NamedQuery(name = User.GET_BY_ID, query = "SELECT u FROM User u WHERE u.id=:id"),
       // @NamedQuery(name = User.DELETE_BY_ID, query = "DELETE FROM User u WHERE u.id=:id AND r.createdBy.id=:userId")
})

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "users")
public class User {
    public static final String GET_BY_ID = "User.createById";


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)                     //ID
    private Long id;

    @Column(name = "name", nullable = false)
    @NotBlank
    @Size (min = 7, max = 20)
    private String name;                                                //the full name of person

    @Column(name = "email", nullable = false, unique = true)
    @NotBlank
    @Email
    @Size(min = 8, max = 20)
    private String email;                                               //unique email - used for identification in the system

    @Column(name = "password", nullable = false)
    @NotBlank
    @Size(min = 5, max = 100)
    private String password;                                            //password of user

    @JsonIgnore
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "userroles", joinColumns = @JoinColumn(name = "user.id"))
    @Column(name = "role")
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Role> roles;                                            //user role from ENUM "Role"

    @JsonIgnore
    @Nullable
    @Column(name = "dateTimeOfVote")
    private LocalDateTime dateTimeOfVote;                               //date and time when that user has voted for

    @JsonIgnore
    @Nullable
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "restoId", referencedColumnName = "id")
    private Restaurant votedFor;                                        //restaurant id, which were voted by user


    public User() {
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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public LocalDateTime getDateTimeOfVote() {
        return dateTimeOfVote;
    }

    public void setDateTimeOfVote(LocalDateTime dateTimeOfVote) {
        this.dateTimeOfVote = dateTimeOfVote;
    }

    public Restaurant getVotedFor() {
        return votedFor;
    }

    public void setVotedFor(Restaurant votedFor) {
        this.votedFor = votedFor;
    }

    public boolean isNew() {
        return this.id == null;
    }
}
