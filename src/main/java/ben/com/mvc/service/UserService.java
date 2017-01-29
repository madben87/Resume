package ben.com.service;

import ben.com.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    void save(User user);
    User findByName(String name);
    User findById(Long id);
}
