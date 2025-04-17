package dev.libeer.libeer.users;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserBA userBA;

    @GetMapping("/")
    public String home() {
        return "Hello User";
    }

    @GetMapping("/all")
    List<User> findAll() {
        return userBA.findAll();
    }
}
