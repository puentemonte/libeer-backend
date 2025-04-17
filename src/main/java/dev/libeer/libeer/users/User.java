package dev.libeer.libeer.users;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class User {

    @JsonProperty
    private UUID id;
    @JsonProperty
    private String username;
    @JsonProperty
    private LocalDateTime lastSeen;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username=" + username +
                "}";
    }

}
