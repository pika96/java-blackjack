# java-blackjack
블랙잭 게임 미션 저장소

## 기능 요구 사항

### 도메인

[참가자]
- 참가자 생성
    - [] 쉼표 기준으로 분리
    - [] 이름 한 글자 이상
    - [] 참가자 중복
    - [] 참가 최대 인원
    
[카드]
- [x] 카드 문양, 번호 ENUM
- [x] 카드 문양, 번호

[카드 덱]
- [x] 서로 다른 52장의 카드를 생성
- [x] 카드를 드로우 할 수 있다.

[플레이어, 딜러 - 추상 클래스]
- [] 보유 카드

[게임 결과]
- [] 딜러와 플레이어간의 승 패 결과

### 게임 진행

[카드 분배]
- [] 딜러와 플레이어에게 카드 2장씩 분배
- [] 딜러 카드는 1장만 공개
- [] 분배한 카드는 덱에서 제거

[카드 추가]
- 플레이어에게 카드를 더 받을 지 물어보기
    - [] 입력은 y나 n 둘 중 하나
    - 카드 합에 따라 달라진다.
        - y : [] 새로운 카드를 뽑기, 현재 보유 카드 출력
        - n : [] 현재 보유 카드 출력
- [] 딜러의 카드 합이 16이하면 17이상이 될 때까지 카드 추가

[게임 결과]
- 딜러와 플레이어가 가진 카드와 합 출력
    - [] Ace 카드는 1이나 11으로 계산
        - [] 21을 넘지 않는 선에서 21에 가깝게 계산
    - [] K,Q,J는 10으로 계산
- 최종 승패 출력
    - 각 플레이어와 딜러 점수 비교
        - 플레이어 승
            - [] 플레이어 카드 합이 21이 넘지 않으면서 딜러보다 높은 경우
            - [] 딜러 카드 합이 21을 넘고 플레이어 카드합이 21을 넘지 않은 경우
        - 딜러 승
            - [] 딜러 카드 합이 21이 넘지 않으면서 플레이어보다 21에 가까운 경우
            - [] 플레이어 카드 합이 21을 넘는 경우
        - 무승부
            - [] 딜러와 플레이어 카드 합이 둘다 21을 넘는 경우
            - [] 딜러와 플레이어 카드 합이 같은 경우
