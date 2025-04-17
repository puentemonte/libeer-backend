package dev.libeer.libeer.users;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserBA {
    private final UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

}
