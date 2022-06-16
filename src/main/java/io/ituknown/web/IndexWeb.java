package io.ituknown.web;

import io.ituknown.domain.User;
import io.ituknown.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class IndexWeb {

    @Autowired
    private UserService userService;

    @GetMapping("/default")
    public List<User> defaultList() {
        return userService.defaultList();
    }

    @GetMapping("/master")
    public List<User> masterList() {
        return userService.masterList();
    }

    @GetMapping("/slave")
    public List<User> slaveList() {
        return userService.slaveList();
    }
}
