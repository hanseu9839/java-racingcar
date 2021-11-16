## 3단계 - 자동차 경주

### 구현 기능 요구사항

1. [x] 사용자 입력을 받는다.
    - n : 자동차 대 수
    - m : 레이싱 시도 횟수


2. [x] 자동차 경주 상태 (자동차 상태)를 출력한다.
    - 한 줄에 한 자동차의 상태가 출력된다.
    - "-" 으로 자동차가 얼마나 전진한지 표현한다. 예) "-" : 한번 전진
    - 전진 표시는 이전 시도에서 전진한 표시에 누적된다. 예) 시도1: "-", 시도2: "--"
    - n 줄 이 끝나면 모든 자동차가 한번의 시도를 끝낸 것이다. 한 시도가 끝나면 "\n"을 붙이고 다음 시도를 출력한다.
    - 최종 출력 결과는 n 대 * m 번의 시도가 출력된다.


3. [x] 한 시도에 자동차가 최대 한번 전진할 수 있다.
    - 한 시도에 n 대의 자동차가 최대 한번 전진할 수 있다.
    - m번의 시도 중, 최대 m 번 전진이 가능하다.
    - 전진 조건: 0~ 9 사이의 숫자 중 랜덤 값을 받아 그 값이 4 이상일 경우