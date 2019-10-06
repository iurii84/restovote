package restovoteApp.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import restovoteApp.SecurityUtil;
import restovoteApp.model.User;
import restovoteApp.service.UserService;

@RestController
@RequestMapping(value = "/admin/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminUserController {
    private UserService userService;
    public AdminUserController (UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/authorise/{userId}" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public void authoriseUser(@PathVariable long userId) {
        long authorisedUser = SecurityUtil.authUserId();
        userService.authoriseUser(userId, authorisedUser);
    }


    @PostMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void editUser(@RequestBody User user, @PathVariable long id) {
        long authorisedUser = SecurityUtil.authUserId();
        userService.editUser(user, id, authorisedUser);

    }
}
