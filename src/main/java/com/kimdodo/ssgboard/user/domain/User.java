package com.kimdodo.ssgboard.user.domain;

import com.kimdodo.ssgboard.common.domain.embed.Address;
import com.kimdodo.ssgboard.common.domain.embed.Gender;
import com.kimdodo.ssgboard.common.service.port.DateHolder;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
public class User {
    private Long id;
    private String email;
    private String password;
    private String name;
    private String nickname;
    private Gender gender;
    private Date birthDate;
    private String telNumber;
    private Address address;
    private Date createAt;
    private Date lastLoginAt;
    private String profileImage;
    @Builder
    public User(Long id, String email, String password, String name, String nickname, Gender gender, Date birthDate, String telNumber, Address address, Date createAt, Date lastLoginAt, String profileImage) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.nickname = nickname;
        this.gender = gender;
        this.birthDate = birthDate;
        this.telNumber = telNumber;
        this.address = address;
        this.createAt = createAt;
        this.lastLoginAt = lastLoginAt;
        this.profileImage = profileImage;
    }

    public static User from(UserCreate userCreate, DateHolder dateHolder){
        Address address = Address.builder()
                .zipcode(userCreate.getZipcode())
                .main(userCreate.getMainAddress())
                .detail(userCreate.getDetailAddress())
                .build();

        return builder()
                .email(userCreate.getEmail())
                .password(userCreate.getPassword())
                .name(userCreate.getName())
                .nickname(userCreate.getNickname())
                .gender(Gender.from(userCreate.getGender()))
                .birthDate(userCreate.getBirthDate())
                .telNumber(userCreate.getTelNumber())
                .address(address)
                .createAt(dateHolder.getNow())
                .build();
    }

    public User edit(UserEdit userEdit) {
        Address editAddress = Address
                .builder()
                .zipcode(userEdit.getZipcode() != null && !userEdit.getZipcode().trim().isEmpty() ? userEdit.getZipcode() : this.address.getZipcode())
                .main(userEdit.getMainAddress() != null && !userEdit.getMainAddress().trim().isEmpty() ? userEdit.getMainAddress() : this.address.getMain())
                .detail(userEdit.getDetailAddress() != null && !userEdit.getDetailAddress().trim().isEmpty() ? userEdit.getDetailAddress() : this.address.getDetail())
                .build();

        return builder()
                .id(this.id)
                .email(this.email)
                .name(this.name)
                .birthDate(this.birthDate)
                .password(userEdit.getPassword() != null && !userEdit.getPassword().trim().isEmpty() ? userEdit.getPassword() : this.password)
                .nickname(userEdit.getNickname() != null && !userEdit.getNickname().trim().isEmpty() ? userEdit.getNickname() : this.nickname)
                .telNumber(userEdit.getTelNumber() != null && !userEdit.getTelNumber().trim().isEmpty() ? userEdit.getTelNumber() : this.telNumber)
                .address(editAddress)
                .createAt(this.createAt)
                .lastLoginAt(this.lastLoginAt)
                .build();
    }
}
