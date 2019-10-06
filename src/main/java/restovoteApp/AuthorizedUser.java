package restovoteApp;

import restovoteApp.model.User;

public class AuthorizedUser extends org.springframework.security.core.userdetails.User {
    private static final long serialVersionUID = 1L;
    private User user;

    public AuthorizedUser(User user) {
        super(user.getEmail(), user.getPassword(), user.isAuthorisedByAdmin(), true, true, true, user.getRoles());
        this.user = user;
    }

    public User getUser() {
        return this.user;
    }
}
