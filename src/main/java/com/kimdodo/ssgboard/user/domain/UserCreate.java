package com.kimdodo.ssgboard.user.domain;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
public class UserCreate {
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

    @Builder
    public UserCreate(String email, String password, String name, String nickname, String gender, Date birthDate, String telNumber, String zipcode, String mainAddress, String detailAddress) {
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
    }

    public void encryptPassword(String encryptedPassword){
        this.password = encryptedPassword;
    }
}
