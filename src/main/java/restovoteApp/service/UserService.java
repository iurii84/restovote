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

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerNewUser(User user) {
        user.setAuthorisedByAdmin(false);
        Set<Role> roles = new HashSet<>();
        roles.add(Role.ROLE_USER);
        user.setRoles(roles);
        return userRepository.save(user);
    }

    public void authoriseUser(long userId, long authorisedUser) {
        if (userRepository.get(authorisedUser).getRoles().contains(Role.ROLE_ADMIN)) {
            User userToAuthorise = userRepository.get(userId);
            if (userToAuthorise.isAuthorisedByAdmin() == false) {
                userToAuthorise.setAuthorisedByAdmin(true);
                userRepository.save(userToAuthorise);
            }
        }
    }

    public void editUser(User user, long id, Long authUser) {
        if (userRepository.get(authUser).getRoles().contains(Role.ROLE_ADMIN)) {
            User oldUser = userRepository.get(id);
            oldUser.setEmail(user.getEmail());
            oldUser.setPassword(user.getPassword());
            oldUser.setName(user.getName());

            userRepository.save(oldUser);
        }
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
