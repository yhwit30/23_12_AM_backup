## 개발환경
java 17 <br>
eclipse

## 회원 + 게시글 프로젝트
<img src="https://github.com/yhwit30/23_12_AM_backup/assets/153142837/6086206c-cbf6-49ec-9793-a4e0d1e833ac">


## 구조
[App / controller / service / dao / dto / util]

- App : console 사용자가 보는 화면 가정
- controller : crud 기능 요청을 분류, 회원가입 및 로그인 기능
- service : 컨트롤러의 요청을 처리
- dao(Data Access Object) : DB 데이터에 접근하기 위한 객체(Repository 느낌)
- dto(Data Transfer Object) : 데이터 이동 위한 객체
- util 클래스 : 날짜 시간 변환과 같은 작업을 위한 메소드 실행

## 메모
- controller 클래스에 static 변수로 member 로그인과 같은 기능을 구현함

  <br>

![image](https://github.com/yhwit30/23_12_AM_backup/assets/153142837/06f282c0-b46c-4903-8e7a-95d8f9faab13)


