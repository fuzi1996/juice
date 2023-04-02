package juice.demo.user.controller;

import juice.demo.user.entity.User;
import juice.demo.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @QueryMapping
    public User userById(@Argument Serializable id) {
        return this.userService.getById(id);
    }

    @GetMapping("/list")
    public List<User> test() {
        return this.userService.list();
    }

    @PostMapping("/add")
    public User add(@RequestBody User user) {
        this.userService.save(user);
        return user;
    }
}
