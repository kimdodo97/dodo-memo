package com.kimdodo.ssgboard.common.domain.embed;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Address {
    String zipcode;
    String main;
    String detail;

    @Builder
    public Address(String zipcode, String main, String detail) {
        this.zipcode = zipcode;
        this.main = main;
        this.detail = detail;
    }
}
