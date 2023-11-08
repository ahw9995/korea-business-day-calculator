# korea-business-day-calculator

## 개요
공휴일 데이터는 https://www.data.go.kr/data/15012690/openapi.do 의 한국천문연구원 특일 정보 기반으로 수집됩니다.

위 사이트에 로그인 하신 후 인증키를 발급 받아 application.yml 파일 내 data-go-kr.auth-key 에 encoding된 코드로 등록해 주세요.

영업일 계산은 현재일 기준 이전 x일, 이후 x일로 계산됩니다.


## API
Swagger-ui: domain/swagger-ui (localhost:8080/swagger-ui)

### API 목록
- /batch/update-holidays, POST
  - 한국천문연구원 휴일 정보 API를 통해 올해 휴일 정보를 조회하여 신규 등록/수정하는 배치
 
- /korea-holidays, GET
  - 현재년도의 모든 공휴일 정보를 조회하는 API
  
- /calculator/business-day, GET
  - 영업일을 계산하는 API
  - Parameters
    - type: before(이전 일 계산) 또는 after(이후 일 계산) 중 입력
    - day: 계산하고자 하는 일 수
    - date: 입력하지 않으면 오늘일자 기준으로 계산 되며, 입력 시에는 날짜포맷은 yyyyMMdd 형태의 문자열로 입력
