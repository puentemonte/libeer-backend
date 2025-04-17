package dev.libeer.libeer.users;

import dev.libeer.libeer.utils.JsonDeserializerUtils;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    private List<User> users = new ArrayList<>();

    @PostConstruct
    private void init()  {
        String json = JsonDeserializerUtils.loadJsonFromFile("/db/initialUserDBDump.json");
        users.addAll(JsonDeserializerUtils.createListFromString(json, User.class));
    }

    List<User> findAll() {
        return users;
    }
}
