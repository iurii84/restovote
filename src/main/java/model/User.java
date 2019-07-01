package model;

import java.time.LocalDateTime;
import java.util.Set;

public class User {
    private Long id;
    private String name;
    private String email; //as identificator
    private String password;

    private Set<Role> roles;

    private LocalDateTime dateTimeOfVote;
    private Restaurant votedFor;
}
