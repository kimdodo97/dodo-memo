package com.kimdodo.ssgboard.common.domain.embed;

public enum Gender {
    MALE,FEMALE;

    public static Gender from(String gender){
        if (gender.equals("MALE") || gender.equals("남")){
            return Gender.MALE;
        }
        else{
            return Gender.FEMALE;
        }
    }
}
