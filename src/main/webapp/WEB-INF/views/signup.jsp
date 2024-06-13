<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="../resources/css/sign-up.css" />
    <title>Document</title>
</head>
<body>
<div class="sign-up-container">
    <div class="sign-up-wrapper">
        <div class="sign-up-form-box">
            <p class="main-title">날개가 없기에 사람은 나는 법을 찾는 것 이다</p>
            <form action="" method="post">
                <div class="input-box">
                    <div class="input-label">이름</div>
                    <input type="text" placeholder="이름" />
                </div>
                <div class="input-box">
                    <div class="input-label">이메일</div>
                    <input type="email" placeholder="이메일을 입력하세요" />
                </div>

                <div class="input-box">
                    <div class="input-label">비밀번호</div>
                    <input type="text" placeholder="비밀번호를 입력하세요" />
                </div>

                <div class="input-box">
                    <div class="input-label">비밀번호 확인</div>
                    <input type="text" placeholder="비밀번호를 재입력 하세요 " />
                    <div class="password-check-label">
                        비밀번호가 일치하지 않습니다
                    </div>
                </div>

                <div class="input-box">
                    <div class="input-label">성별</div>
                    <select name="gender" id="gender">
                        <option value="male">남자</option>
                        <option value="female">여자</option>
                    </select>
                </div>

                <div class="input-box">
                    <div class="input-label">생년원일</div>
                    <input type="date" placeholder="이름" />
                </div>
                <div class="input-box">
                    <div class="input-label">전화번호</div>
                    <input type="tel" placeholder="01012341234" />
                </div>
                <div class="input-box">
                    <div class="input-label">주소</div>
                    <div class="address-box">
                        <input class="zipcode" type="text" placeholder="우편번호" />
                        <input
                                class="search-address-btn"
                                type="button"
                                onclick="test()"
                                value="우편번호 찾기"
                        />
                    </div>
                    <div class="address-box">
                        <input type="text" class="main-address" placeholder="주소" />
                    </div>
                    <div class="address-box">
                        <input
                                type="text"
                                class="detail-address"
                                placeholder="상세주소"
                        />
                    </div>
                    <button class="signup-btn" type="submit">가입하기</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
