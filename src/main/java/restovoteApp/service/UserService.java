package restovoteApp.service;

import org.springframework.stereotype.Service;
import restovoteApp.model.User;
import restovoteApp.repository.UserRepository;

@Service
public class UserService {
    private UserRepository userRepository;
    public UserService (UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerNewUser(User user) {
        return userRepository.save (user);
    }

}
