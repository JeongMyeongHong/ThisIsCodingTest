package com.example.thisiscodingtest.part02.ch3;

/**
 * packageName   :   com.example.thisiscodingtest.part02.ch3
 * fileName      :   greedy
 * author        :   JeongMyeongHong
 * date          :   2022-02-23
 * desc          :
 * ============================================
 * DATE             AUTHOR              NOTE
 * ============================================
 * 2022-02-23      JeongmyoengHong     최초 생성
 */
public interface Greedy {
    void changeMoney();
    /**
     * 거스름돈 (87P)
     * 손님에게 N 원을 거슬러줘야한다.
     * 500원, 100원, 50원, 10원짜리 동전을 무한대로 가지고있다고 가정하고
     * 최소한의 동전 갯수로 거슬러주어라.
     * 단, 거스름돈의 액수는 항상 10의 배수이다.
     * */


    void lawOfNum();
    /**
     * 큰수의 법칙 (92P)
     * 다양한 수로 이루어진 배열이 있다 ex)_ {3, 4, 5, 4, 5, 6}
     * 주어진 수를 M번을 더하여 가장 큰 수를 만들어라.
     * 동일한 Index의 숫자를 연속해서 K번을 초과하여 사용 할 수 없다.
     * 예를 들어, M=5, K=3 이라면 6 + 6 + 6 + 5 + 6 이 될 것이다.
     * 만약 주어진 배열이 {3, 4, 6, 6 } 이라면
     * 6이 다른 Index 이므로 6 + 6 + 6 + 6 + 6이 될 것이다.
     * */


    void cardGame();
    /**
     * 숫자 카드 게임 (96P)
     * 1. N * M 의 형태로 카드가 놓여있다.
     * 2. 뽑고자 하는 행을 선택한다.
     * 3. 선택된 행의 카드들 중 가장 숫자를 뽑는다.
     * 4. 이때 나온 숫자는 어떠한 행을 선택해도 가장 큰 값이어야 한다.
     * 5. 출력 결과는 나올 수 있는 가장 큰 값 이다.
     *
     * 조건 : N과 M 은 1~100까지의 랜덤 정수이다.
     * 각 요소들은 1~10000 까지의 랜덤 정수이다.
     * */


    void toNumberOne();

    /**
     * 1이 될 때까지 (99P)
     * 자연수 N 이 1이 될 때까지 아래의 과정을 반복적으로 선택 수행한다.
     * (N 과 K 는 2 ~ 100000 사이의 랜덤 정수이다.)
     * 1. N에서 1을 뺀다.
     * 2. N을 K로 나눈다.
     * 3. N을 1로 만드는 과정의 최솟값을 구하여라.
     *
     *
     * ex)_ N = 17 K = 4 인 경우
     * 1번 과정을 수행 후 2번과정을 두번 하면
     * 17  ->  16  ->  4  ->  1  이 된다.
     * 총 실행 횟수는 3회로 N을 1로 만들 수 있는 최소 횟수가 된다.
     * */
}
