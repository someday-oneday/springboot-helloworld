package com.example.cacheexamples.mapper;

import com.example.cacheexamples.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class UserMapper {
    private static final List<User> USERS;
    static {
        User u1 = User.builder().id(1L).name("BO").build();
        User u2 = User.builder().id(2L).name("SUN").build();
        USERS = new ArrayList<>();
        USERS.add(u1);
        USERS.add(u2);
    }
    public User getUser(long uid){
        return USERS.stream()
                .filter(u -> u.getId() == uid)
                .findFirst()
                .orElse(null);
    }
    // stream()产生新集合，而模拟需要改变原集合
    public User updateUser(User user){
        for (int i = 0; i < USERS.size(); i++){
            if (Objects.equals(user.getId(), USERS.get(i).getId())){
                USERS.set(i, user);
            }
        }
        return user;
    }
    public List<User> listUsers(){
        return USERS;
    }
}