package restovote.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import restovote.SecurityUtil;
import restovote.service.VoteService;

@RestController
@RequestMapping(value = "/vote")
public class VoteController {
    private VoteService voteService;


    public VoteController (VoteService voteService) {
        this.voteService = voteService;
    }

    @PostMapping
    public void voteForRestaurant(@RequestParam Long restoid) {
        long authorisedUser = SecurityUtil.authUserId();
        voteService.vote(authorisedUser, restoid);
    }
}
