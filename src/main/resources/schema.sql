CREATE TABLE POST (
                      post_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      title VARCHAR(255) NOT NULL,
                      content VARCHAR(255) NOT NULL,
                      create_at DATE NOT NULL
);

CREATE TABLE user
(
    user_id        BIGINT       NOT NULL  AUTO_INCREMENT  COMMENT '사용자 ID',
    email          VARCHAR(50)  NOT NULL UNIQUE COMMENT '사용자 이메일',
    password       VARCHAR(100) NOT NULL COMMENT '사용자 비밀번호',
    name       VARCHAR(20)      NOT NULL COMMENT '사용자 이름',
    nickname       VARCHAR(20)  NOT NULL UNIQUE COMMENT '사용자 닉네임',
    gender       VARCHAR(10)  NOT NULL  COMMENT '사용자 성별',
    tel_number     VARCHAR(15)  NOT NULL COMMENT '사용자 전화번호',
    zipcode        TEXT         NULL COMMENT '사용자 우편번호',
    main_address        TEXT         NULL COMMENT '사용자 주소',
    detail_address TEXT         NULL     COMMENT '사용자 상세 주소',
    create_at DATE NOT NULL ,
    last_login_at DATE NULL,
    profile_image  TEXT         NULL     COMMENT '사용자 프로필 이미지',
    PRIMARY KEY (user_id)
)
