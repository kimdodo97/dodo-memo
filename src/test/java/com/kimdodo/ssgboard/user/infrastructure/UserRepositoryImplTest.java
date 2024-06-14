package com.kimdodo.ssgboard.user.infrastructure;

import com.kimdodo.ssgboard.common.domain.embed.Address;
import com.kimdodo.ssgboard.common.domain.embed.Gender;
import com.kimdodo.ssgboard.common.service.port.DateHolder;
import com.kimdodo.ssgboard.mock.TestDateHolder;
import com.kimdodo.ssgboard.user.domain.User;
import com.kimdodo.ssgboard.user.service.port.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;
import java.time.ZoneOffset;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryImplTest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;
    TestDateHolder dateHolder = new TestDateHolder(Date.from(Instant.parse("2023-12-12T00:00:00Z")));

    @Test
    void userId로_사용자를_찾을수있다() throws Exception {
        //given
        UserEntity userEntity = UserEntity.builder()
                .id(1L)
                .email("kimdodo@naver.com")
                .password("1234")
                .name("김도도")
                .nickname("kimdodo")
                .gender(Gender.MALE)
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
        assertEquals("1234",user.getPassword());
        assertEquals("김도도",user.getName());
        assertEquals("kimdodo",user.getNickname());
        assertEquals(Gender.MALE,user.getGender());
        assertEquals(dateHolder.getNow(),user.getBirthDate());
        assertEquals("12345",user.getAddress().getZipcode());
        assertEquals("부산",user.getAddress().getMain());
        assertEquals("1501호",user.getAddress().getDetail());
        assertEquals(dateHolder.getNow(),user.getCreateAt());
    }

    @Test
    void email로_사용자를_찾을수있다() throws Exception {
        //given
        UserEntity userEntity = UserEntity.builder()
                .id(1L)
                .email("kimdodo@naver.com")
                .password("1234")
                .name("김도도")
                .nickname("kimdodo")
                .gender(Gender.MALE)
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
        User user = userRepository.findByEmail("kimdodo@naver.com").get();
        //then
        assertEquals("kimdodo@naver.com",user.getEmail());
        assertEquals("1234",user.getPassword());
        assertEquals("김도도",user.getName());
        assertEquals("kimdodo",user.getNickname());
        assertEquals(Gender.MALE,user.getGender());
        assertEquals(dateHolder.getNow(),user.getBirthDate());
        assertEquals("12345",user.getAddress().getZipcode());
        assertEquals("부산",user.getAddress().getMain());
        assertEquals("1501호",user.getAddress().getDetail());
        assertEquals(dateHolder.getNow(),user.getCreateAt());
    }

    @Test
    void email과pasword로_사용자를_찾을수있다() throws Exception {
        //given
        UserEntity userEntity = UserEntity.builder()
                .id(1L)
                .email("kimdodo@naver.com")
                .password("1234")
                .name("김도도")
                .nickname("kimdodo")
                .gender(Gender.MALE)
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
        User user = userRepository.findByEmailAndPassword("kimdodo@naver.com","1234").get();
        //then
        assertEquals("kimdodo@naver.com",user.getEmail());
        assertEquals("1234",user.getPassword());
        assertEquals("김도도",user.getName());
        assertEquals("kimdodo",user.getNickname());
        assertEquals(Gender.MALE,user.getGender());
        assertEquals(dateHolder.getNow(),user.getBirthDate());
        assertEquals("12345",user.getAddress().getZipcode());
        assertEquals("부산",user.getAddress().getMain());
        assertEquals("1501호",user.getAddress().getDetail());
        assertEquals(dateHolder.getNow(),user.getCreateAt());
    }

    @Test
    void User객체를통해서_DB에_사용자정보를_저장가능하다() throws Exception {
        //given
        Address address = Address.builder()
                .zipcode("12345")
                .main("부산")
                .detail("1501호")
                .build();

        User user = User.builder()
                .id(1L)
                .email("kimdodo@naver.com")
                .password("1234")
                .name("김도도")
                .nickname("kimdodo")
                .gender(Gender.MALE)
                .birthDate(dateHolder.getNow())
                .address(address)
                .telNumber("01012341234")
                .createAt(dateHolder.getNow())
                .lastLoginAt(dateHolder.getNow())
                .build();
        //when
        userRepository.save(user);
        UserEntity userEntity = userMapper.findById(1L).get();
        //then
        assertEquals("kimdodo@naver.com",userEntity.getEmail());
        assertEquals("1234",userEntity.getPassword());
        assertEquals("김도도",userEntity.getName());
        assertEquals("kimdodo",userEntity.getNickname());
        assertEquals("MALE",userEntity.getGender());
        assertEquals(dateHolder.getNow(),userEntity.getBirthDate());
        assertEquals("12345",userEntity.getZipcode());
        assertEquals("부산",userEntity.getMainAddress());
        assertEquals("1501호",userEntity.getDetailAddress());
        assertEquals(dateHolder.getNow(),userEntity.getCreateAt());
    }

    @Test
    void UserEdit을_통해서_사용자정보를_수정가능하다() throws Exception {
        //given
        UserEntity userEntity = UserEntity.builder()
                .id(1L)
                .email("kimdodo@naver.com")
                .password("1234")
                .name("김도도")
                .nickname("kimdodo")
                .gender(Gender.MALE)
                .birthDate(dateHolder.getNow())
                .zipcode("12345")
                .mainAddress("부산")
                .detailAddress("1501호")
                .telNumber("01012341234")
                .createAt(dateHolder.getNow())
                .lastLoginAt(dateHolder.getNow())
                .build();
        userMapper.save(userEntity);

        Address address = Address.builder()
                .zipcode("11111")
                .main("서울 강남")
                .detail("도도빌딩")
                .build();

        User user = User.builder()
                .id(1L)
                .email("kimdodo@naver.com")
                .password("1111")
                .name("김도도")
                .nickname("kimdodo2")
                .gender(Gender.MALE)
                .birthDate(dateHolder.getNow())
                .address(address)
                .telNumber("01056785678")
                .createAt(dateHolder.getNow())
                .lastLoginAt(dateHolder.getNow())
                .build();

        //when
        userRepository.update(user);
        UserEntity savedEntity = userMapper.findById(1L).get();
        //then
        assertEquals("1111",savedEntity.getPassword());
        assertEquals("kimdodo2",savedEntity.getNickname());
        assertEquals("11111",savedEntity.getZipcode());
        assertEquals("서울 강남",savedEntity.getMainAddress());
        assertEquals("도도빌딩",savedEntity.getDetailAddress());
        assertEquals("01056785678",savedEntity.getTelNumber());
    }
}