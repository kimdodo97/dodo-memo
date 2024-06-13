<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="../resources/css/sign-in.css"/>
    <link
            href="https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css"
            rel="stylesheet"
    />
    <title>Login</title>
</head>
<body>
<section class="section">
    <div class="wrapper">
        <div class="logreg-box">
            <!-- 로그인 영역 -->
            <div class="form-box login">
                <div class="logreg-title">
                    <a href="/"><img src="../resources/img/main.png" alt=""></a>
                    <p>국내 유일 배구 플랫폼 디그</p>
                </div>
                <form action="">
                    <div class="input-box">
                <span class="icon"
                ><i class='bx bxs-envelope'></i></box-icon
                        ></span>
                        <input type="email" />
                        <label for="">이메일</label>
                    </div>
                    <div class="input-box">
                <span class="icon"
                ><i class='bx bxs-lock-alt'></i></box-icon
                        ></span>
                        <input type="password" />
                        <label for="">비밀번호</label>
                    </div>

                    <div class="remember-forgot">
                        <label>
                            <input type="checkbox">자동 로그인</label>
                        <a href="">이메일/비밀번호 찾기</a>
                    </div>
                    <button type="submit" class="btn">로그인</button>

                    <div class="logreg-link">
                        <p>회원이 아니신가요?
                            <a href="/auth/signup">
                                회원가입
                            </a>
                        </p>
                    </div>
                </form>
            </div>
        </div>
    </div>
    </div>
</section>
</body>
</html>
