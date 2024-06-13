package com.kimdodo.ssgboard.user.infrastructure;

import com.kimdodo.ssgboard.common.domain.embed.Address;
import com.kimdodo.ssgboard.common.domain.embed.Gender;
import com.kimdodo.ssgboard.user.domain.User;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

import static org.apache.tomcat.jni.Buffer.address;
import static org.apache.tomcat.jni.Buffer.create;

@Getter
public class UserEntity {
    private Long id;
    private String email;
    private String password;
    private String name;
    private String nickname;
    private Gender gender;
    private LocalDateTime birthDate;
    private String telNumber;
    private String zipcode;
    private String mainAddress;
    private String detailAddress;
    private LocalDateTime createAt;
    private LocalDateTime lastLoginAt;
    private String profileImage;

    @Builder
    public UserEntity(Long id, String email, String password, String name, String nickname, Gender gender, LocalDateTime birthDate, String telNumber, String zipcode, String mainAddress, String detailAddress, LocalDateTime createAt, LocalDateTime lastLoginAt, String profileImage) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.nickname = nickname;
        this.gender = gender;
        this.birthDate = birthDate;
        this.telNumber = telNumber;
        this.zipcode = zipcode;
        this.mainAddress = mainAddress;
        this.detailAddress = detailAddress;
        this.createAt = createAt;
        this.lastLoginAt = lastLoginAt;
        this.profileImage = profileImage;
    }

    public User toModel(){
        Address address = Address.builder()
                .zipcode(zipcode)
                .main(mainAddress)
                .detail(detailAddress).build();
        return User.builder()
                .id(id)
                .email(email)
                .password(password)
                .name(name)
                .nickname(nickname)
                .gender(gender)
                .birthDate(birthDate)
                .telNumber(telNumber)
                .address(address)
                .createAt(createAt)
                .lastLoginAt(lastLoginAt)
                .profileImage(profileImage)
                .build();
    }

    public static UserEntity fromModel(User user){
        return UserEntity.builder()
                .id(user.getId())
                .email(user.getEmail())
                .password(user.getPassword())
                .name(user.getName())
                .birthDate(user.getBirthDate())
                .nickname(user.getNickname())
                .telNumber(user.getTelNumber())
                .zipcode(user.getAddress().getZipcode())
                .mainAddress(user.getAddress().getMain())
                .detailAddress(user.getAddress().getDetail())
                .profileImage(user.getProfileImage())
                .createAt(user.getCreateAt())
                .lastLoginAt(user.getLastLoginAt())
                .build();
    }
}
