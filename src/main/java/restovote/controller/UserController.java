package restovote.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import restovote.model.User;
import restovote.service.UserService;

import java.net.URI;

@RestController
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
    private UserService userService;


    @Autowired //can be omitted
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> registerNewUser(@RequestBody User user) {
        User registered = userService.registerNewUser(user);
        URI uriOfNewUser = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/user" + "/{id}")
                .buildAndExpand(registered.getId()).toUri();
        return ResponseEntity.created(uriOfNewUser).body(registered);
    }

}
