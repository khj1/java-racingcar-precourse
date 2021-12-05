# 자동차 경주 게임 규칙
- 경주에 참여할 n대의 자동차의 이름을 입력한다. (이름은 쉼표로 구분)
- 사용자는 게임 횟수를 입력하고 각 차수별로 자동차는 전진 또는 정지 상태가 임의로 결정된다.
- 입력된 게임 횟수가 끝난 뒤 가장 먼 거리를 이동한 자동차가 승리한다. (공동 우승 가능)

# 구현 목록
## 기능
- 자동차 생성 시 5자 이하의 이름을 부여한다.
   - [예외] 이름이 5자를 초과하는 경우
- 자동차 이름은 쉼표(,)를 기준으로 구분한다.
- 주어진 횟수 동안 n대의 자동차는 전진 또는 정지한다.
- 자동차의 상태는 난수를 통해 임의로 결정된다.
  - 전진하는 조건은 0에서 9 사이의 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 가장 먼 거리를 이동한 자동차가 우승한다. 공동 우승자가 존재할 수 있다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`를 발생시킨다.
## 입력
- 경주 할 자동차 이름은 쉼표로 구분하여 입력받는다.
   ```
   경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
   pobi,woni,jun
   ```
- 시도할 횟수를 정수로 입력받는다.

   ```
   시도할 회수는 몇회인가요?
   5
   ```
  - [예외] 문자열이 입력되는 경우
  - [예외] 정수가 아닌 숫자가 입력되는 경우
- 에러 메세지가 출력되면 예외가 발생한 부분을 다시 입력 받는다.

## 출력
- 각 차수별 실행 결과 출력, 자동차 이름을 같이 출력한다.
   ```
   실행 결과
   pobi : -
   woni :
   jun : -
    
   pobi : --
   woni : -
   jun : --
    
   pobi : ---
   woni : --
   jun : ---
    
   pobi : ----
   woni : ---
   jun : ----
    
   pobi : -----
   woni : ----
   jun : -----
   ```
- 우승자 안내 구문 출력 (우승자가 여러명인 경우 쉼표로 구분한다.)
   ```
   최종 우승자 : pobi, jun
   ```
- 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 [ERROR]로 시작해야한다.
   ```
   [ERROR] 시도 횟수는 숫자여야 한다.
   ```