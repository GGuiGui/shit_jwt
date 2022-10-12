# shit_jwt
jwt 로그인 및 조회 수정 완성

##회원가입POST
http://100.26.194.86/auth/signup
헤더
Content-Type: application/json

바디
{
  "email": "qwer1",
  "password": "qwer",
  "repassword": "qwer"
}

##로그인POST
http://100.26.194.86/auth/login
헤더
Content-Type: application/json

바디
{
  "email": "qwer1",
  "password": "qwer"
}

##tokensend GET
http://100.26.194.86/member/me
헤더
Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxIiwiYXV0aCI6IlJPTEVfVVNFUiIsImV4cCI6MTY2NTU5MzA4Nn0.JvNNXTJvuTFO_EFX3ShxLPLXjq0Du1Xck7rC55c_fDInmN6nt9oru098SucqFX9isnGIv2nV0RjDUoYYTLy9Gw

##refreshtoken POST
http://100.26.194.86/auth/reissue
헤더
Content-Type: application/json

바디
{
"accessToken": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxIiwiYXV0aCI6IlJPTEVfVVNFUiIsImV4cCI6MTY2NTU5MzA4Nn0.JvNNXTJvuTFO_EFX3ShxLPLXjq0Du1Xck7rC55c_fDInmN6nt9oru098SucqFX9isnGIv2nV0RjDUoYYTLy9Gw",
"refreshToken": "eyJhbGciOiJIUzUxMiJ9.eyJleHAiOjE2NjU1OTU3ODZ9.luizBhr60e-pmkxAlAVPkkWtX1iG0LMsXDW855306CxMzgPPYB75_2RJA5voW3wYtE5Ck5t-uopSbAXoyiHUzQ"
}



##Post작성POST
http://100.26.194.86/show/board
헤더
Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIyIiwiYXV0aCI6IlJPTEVfVVNFUiIsImV4cCI6MTY2NTU5MjQ0N30.S1SmFhvUAQ_vk93UjP4UzlaKGrBsxWjiYBRFu-PGkwUkJx097frjDNxxviC6zQR8Ps7D1UtnQCRPJhepHc8vyg
Content-Type: application/json

바디
{
    "title": "2번째",
    "content": "content2"
}

##Post초이스 조회GET
http://100.26.194.86/show/board/{postid}

##Post수정PUT
http://100.26.194.86/modify/board/{postid}
헤더
Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIyIiwiYXV0aCI6IlJPTEVfVVNFUiIsImV4cCI6MTY2NTU5MjQ0N30.S1SmFhvUAQ_vk93UjP4UzlaKGrBsxWjiYBRFu-PGkwUkJx097frjDNxxviC6zQR8Ps7D1UtnQCRPJhepHc8vyg
Content-Type: application/json

바디
{
    "title": "바꿈",
    "content": "내용입니다.2"
}


##Post삭제 delete
http://100.26.194.86/modify/board/{post_id}
헤더
Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIyIiwiYXV0aCI6IlJPTEVfVVNFUiIsImV4cCI6MTY2NTU5MjQ0N30.S1SmFhvUAQ_vk93UjP4UzlaKGrBsxWjiYBRFu-PGkwUkJx097frjDNxxviC6zQR8Ps7D1UtnQCRPJhepHc8vyg




##Comment 추가 POST
http://100.26.194.86/modify/comment
헤더
Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIyIiwiYXV0aCI6IlJPTEVfVVNFUiIsImV4cCI6MTY2NTU5MjQ0N30.S1SmFhvUAQ_vk93UjP4UzlaKGrBsxWjiYBRFu-PGkwUkJx097frjDNxxviC6zQR8Ps7D1UtnQCRPJhepHc8vyg
Content-Type: application/json

바디
{
    "postid": 2,
    "content": "입니다."
}

##Comment 조회 GET
http://100.26.194.86/show/comments


##Comment 수정 PUT
http://100.26.194.86/modify/comment/{post_id}
헤더
Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIyIiwiYXV0aCI6IlJPTEVfVVNFUiIsImV4cCI6MTY2NTU5MjQ0N30.S1SmFhvUAQ_vk93UjP4UzlaKGrBsxWjiYBRFu-PGkwUkJx097frjDNxxviC6zQR8Ps7D1UtnQCRPJhepHc8vyg
Content-Type: application/json

바디
{
    "postid": 2,
    "content": "ㅎㅇ"
}


##Comment 삭제 DELETE
http://100.26.194.86/modify/comment/
헤더
Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIyIiwiYXV0aCI6IlJPTEVfVVNFUiIsImV4cCI6MTY2NTU5MjQ0N30.S1SmFhvUAQ_vk93UjP4UzlaKGrBsxWjiYBRFu-PGkwUkJx097frjDNxxviC6zQR8Ps7D1UtnQCRPJhepHc8vyg
