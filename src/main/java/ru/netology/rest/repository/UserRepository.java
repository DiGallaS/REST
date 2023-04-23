package ru.netology.rest.repository;

import org.springframework.stereotype.Repository;
import ru.netology.rest.authorities.Authorities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class UserRepository {
    public List<Authorities> getUserAuthorities(String user, String password) {
        List<Authorities> authorities= new ArrayList<>();
        if (user.equals("admin") && password.equals("12345")) {
            Collections.addAll(authorities, Authorities.READ, Authorities.WRITE, Authorities.DELETE);
        } else if (user.equals("moderator") && password.equals("qwerty")) {
            Collections.addAll(authorities, Authorities.READ, Authorities.WRITE);
        } else if (user.equals("user") && password.equals("1111")) {
            Collections.addAll(authorities, Authorities.READ);
        }
        return authorities;
    }
}
