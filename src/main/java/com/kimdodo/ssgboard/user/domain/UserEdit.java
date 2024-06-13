package com.kimdodo.ssgboard.user.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class UserEdit {
    private String password;
    private String name;
    private String nickname;
    private String telNumber;
    private String zipcode;
    private String mainAddress;
    private String detailAddress;

}
