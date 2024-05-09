## 회원 + 게시글 프로젝트
<img src="https://private-user-images.githubusercontent.com/153146836/327693850-5cf1cb06-c9b1-413a-a828-15989003339a.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3MTUyMjA2MjcsIm5iZiI6MTcxNTIyMDMyNywicGF0aCI6Ii8xNTMxNDY4MzYvMzI3NjkzODUwLTVjZjFjYjA2LWM5YjEtNDEzYS1hODI4LTE1OTg5MDAzMzM5YS5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjQwNTA5JTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI0MDUwOVQwMjA1MjdaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT1lYzRlYThjMTQzMDg3NDU5OTVkZDk4ZWE4ZDA1ODZhZDc5ZWYwZWU2ODBlMjY2ZmE2NTY4MGQ1MDg4OGIwZTNiJlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCZhY3Rvcl9pZD0wJmtleV9pZD0wJnJlcG9faWQ9MCJ9.u1HWZLlQWvNOIumdKPSwN29W_pMens1vblWCJeOy1JU">


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


