package restovoteApp.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import restovoteApp.SecurityUtil;
import restovoteApp.service.VoteService;

@RestController
@RequestMapping(value = "/vote", produces = MediaType.APPLICATION_JSON_VALUE)
public class VoteController {
    private VoteService voteService;


    public VoteController (VoteService voteService) {
        this.voteService = voteService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void voteForRestaurant(@RequestParam Long restoId) {
        long authorisedUser = SecurityUtil.authUserId();
        voteService.vote(authorisedUser, restoId);
    }
}
