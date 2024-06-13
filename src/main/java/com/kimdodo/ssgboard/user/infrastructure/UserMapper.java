package com.kimdodo.ssgboard.user.infrastructure;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserMapper {
    Optional<UserEntity> findById(Long id);

    List<UserEntity> findAll();
    Optional<UserEntity> findByEmailAndPassword(String email,String password);
    Optional<UserEntity> findByEmail(String email);
    Optional<UserEntity> findByNickname(String nickname);
    Long save(UserEntity userEntity);

    void update(UserEntity userEntity);

    void delete(Long postId);

    void deleteAll();
}
