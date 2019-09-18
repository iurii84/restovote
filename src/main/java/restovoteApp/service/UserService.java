package restovoteApp.service;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import restovoteApp.AuthorizedUser;
import restovoteApp.model.Role;
import restovoteApp.model.User;
import restovoteApp.repository.UserRepository;

import java.util.HashSet;
import java.util.Set;


@Service("userService")
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserService implements UserDetailsService {
    private UserRepository userRepository;
    public UserService (UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerNewUser(User user) {
        user.setAuthorisedByAdmin(false);
        Set<Role> roles = new HashSet<>();
        roles.add(Role.ROLE_USER);
        user.setRoles(roles);
        return userRepository.save (user);
    }

    @Override
    public AuthorizedUser loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.getByEmail(email.toLowerCase());
        if (user == null) {
            throw new UsernameNotFoundException("User " + email + " is not found");
        }
        return new AuthorizedUser(user);
    }
}
