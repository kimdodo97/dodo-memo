package com.kimdodo.ssgboard.user.infrastructure;

import com.kimdodo.ssgboard.common.service.port.DateHolder;
import com.kimdodo.ssgboard.mock.TestDateHolder;
import com.kimdodo.ssgboard.user.domain.User;
import com.kimdodo.ssgboard.user.service.port.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryImplTest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;
    DateHolder dateHolder = new TestDateHolder("2023-01-01");

    @Test
    void userId로_사용자를_찾을수있다() throws Exception {

        //given
        UserEntity userEntity = UserEntity.builder()
                .id(1L)
                .email("kimdodo@naver.com")
                .password("1234")
                .name("김도도")
                .nickname("kimdodo")
                .birthDate(dateHolder.getNow())
                .zipcode("12345")
                .mainAddress("부산")
                .detailAddress("1501호")
                .telNumber("01012341234")
                .createAt(dateHolder.getNow())
                .lastLoginAt(dateHolder.getNow())
                .build();
        userMapper.save(userEntity);

        //when
        User user = userRepository.findById(1L).get();
        //then
        assertEquals("kimdodo@naver.com",user.getEmail());
        
    }
}