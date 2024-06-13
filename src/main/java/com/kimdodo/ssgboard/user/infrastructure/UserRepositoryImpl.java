package com.kimdodo.ssgboard.user.infrastructure;

import com.kimdodo.ssgboard.user.domain.User;
import com.kimdodo.ssgboard.user.service.port.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {
    private final UserMapper userMapper;
    @Override
    public Optional<User> findById(Long id) {
        return userMapper.findById(id).map(UserEntity::toModel);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userMapper.findByEmail(email).map(UserEntity::toModel);
    }

    @Override
    public Optional<User> findByEmailAndPassword(String email, String password) {
        return userMapper.findByEmailAndPassword(email,password).map(UserEntity::toModel);
    }

    @Override
    public User save(User user) {
        UserEntity userEntity = UserEntity.fromModel(user);
        userMapper.save(userEntity);
        return userEntity.toModel();
    }

    @Override
    public User update(User user) {
        UserEntity userEntity = UserEntity.fromModel(user);
        userMapper.update(userEntity);
        return userEntity.toModel();
    }

    @Override
    public void delete(Long id) {
        userMapper.delete(id);
    }
}
