package restovote.service;

import org.springframework.stereotype.Service;
import restovote.model.User;
import restovote.repository.RestaurantRepository;
import restovote.repository.UserRepository;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
public class VoteService {
    private static final LocalTime VOTE_DEADLINE = LocalTime.of(11, 00);
    private UserRepository userRepository;
    private RestaurantRepository restaurantRepository;

    public VoteService(UserRepository userRepository, RestaurantRepository restaurantRepository) {
        this.userRepository = userRepository;
        this.restaurantRepository = restaurantRepository;
    }

    public void vote(Long userId, Long restoId) {
        LocalDateTime dateTimeNow = LocalDateTime.now();
        LocalTime timeNow = LocalTime.now();
        User currentUser = userRepository.get(userId);


        if (currentUser.getDateTimeOfVote() == null || currentUser.getVotedFor() == null) {
            currentUser.setDateTimeOfVote(dateTimeNow);
            currentUser.setVotedFor(restaurantRepository.get(restoId));
            userRepository.save(currentUser);
        }

        if (timeNow.isBefore(VOTE_DEADLINE)) {
            currentUser.setDateTimeOfVote(dateTimeNow);
            currentUser.setVotedFor(restaurantRepository.get(restoId));

            userRepository.save(currentUser);
        }

    }
}
