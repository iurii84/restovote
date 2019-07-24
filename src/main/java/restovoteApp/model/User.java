package restovoteApp.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)                     //ID
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

//    @Enumerated(EnumType.STRING)
//    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user.id"))
//    @Column(name = "role")
//    @ElementCollection(fetch = FetchType.EAGER)
//    private Set<Role> roles;                                            //user role from ENUM "Role"

    @Column(name = "dateTimeOfVote", nullable = false)
    private LocalDateTime dateTimeOfVote;                               //date and time when that user has voted for

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "restoId", referencedColumnName = "id", nullable = false)
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

//    public Set<Role> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(Set<Role> roles) {
//        this.roles = roles;
//    }

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
}
