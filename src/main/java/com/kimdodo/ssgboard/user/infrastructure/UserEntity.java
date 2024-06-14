package com.kimdodo.ssgboard.user.infrastructure;

import com.kimdodo.ssgboard.common.domain.embed.Address;
import com.kimdodo.ssgboard.common.domain.embed.Gender;
import com.kimdodo.ssgboard.user.domain.User;
import lombok.Builder;
import lombok.Getter;
import java.util.Date;

@Getter
public class UserEntity {
    private Long id;
    private String email;
    private String password;
    private String name;
    private String nickname;
    private String gender;
    private Date birthDate;
    private String telNumber;
    private String zipcode;
    private String mainAddress;
    private String detailAddress;
    private Date createAt;
    private Date lastLoginAt;
    private String profileImage;

    @Builder
    public UserEntity(Long id, String email, String password, String name, String nickname, Gender gender, Date birthDate, String telNumber, String zipcode, String mainAddress, String detailAddress, Date createAt, Date lastLoginAt, String profileImage) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.nickname = nickname;
        this.gender = gender.toString();
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
                .gender(Gender.from(gender))
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
                .gender(user.getGender())
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
