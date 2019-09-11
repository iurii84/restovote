package restovoteApp.service;

import org.springframework.stereotype.Service;
import restovoteApp.model.User;
import restovoteApp.repository.RestaurantRepository;
import restovoteApp.repository.UserRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
public class VoteService {
    private static final LocalTime LAST_VOTE_TIME = LocalTime.of(11, 00);
    private UserRepository userRepository;
    private RestaurantRepository restaurantRepository;

    public VoteService(UserRepository userRepository, RestaurantRepository restaurantRepository) {
        this.userRepository = userRepository;
        this.restaurantRepository = restaurantRepository;
    }


    public void vote(Long userId, Long restoId) {
        LocalDateTime dateTimeNow = LocalDateTime.now();
        LocalDate dateNow = LocalDate.now();
        LocalTime timeNow = LocalTime.now();
        User currentUser = userRepository.get(userId);

        System.out.println(currentUser.getDateTimeOfVote());
        if (currentUser.getDateTimeOfVote() == null || currentUser.getVotedFor() == null) {
            currentUser.setDateTimeOfVote(dateTimeNow);
            currentUser.setVotedFor(restaurantRepository.get(restoId));
            userRepository.save(currentUser);
        }

        if (timeNow.isBefore(LAST_VOTE_TIME)) {
            currentUser.setDateTimeOfVote(dateTimeNow);
            currentUser.setVotedFor(restaurantRepository.get(restoId));
            System.out.println(currentUser.getName());
            System.out.println(currentUser.getEmail());
            System.out.println(currentUser.getPassword());
            userRepository.save(currentUser);
        }

    }
}
