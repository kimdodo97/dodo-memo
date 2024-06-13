package com.kimdodo.ssgboard.user.service.port;
import com.kimdodo.ssgboard.user.domain.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findById(Long id);
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email,String password);
    User save(User user);

    User update(User user);

    void delete(Long id);
}
