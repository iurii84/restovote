package model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Set;

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

    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user.id"))
    @Column(name = "role")
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Role> roles;                                            //user role from ENUM "Role"

    @Column(name = "dateTimeOfVote", nullable = false)
    private LocalDateTime dateTimeOfVote;                               //date and time when that user has voted for

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "resto_id", referencedColumnName = "id", nullable = false)
    private Restaurant votedFor;                                        //restaurant id, which were voted by user
}
