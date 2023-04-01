package juice.demo.user.controller;

import juice.demo.user.entity.User;
import juice.demo.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

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
