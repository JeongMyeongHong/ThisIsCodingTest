package com.example.thisiscodingtest.part02.ch3;

/**
 * packageName   :   com.example.thisiscodingtest.part02.ch3
 * fileName      :   no1
 * author        :   JeongMyeongHong
 * date          :   2022-02-23
 * desc          :  Part2 ch3.그리디
 * <p>
 * ============================================
 * DATE             AUTHOR              NOTE
 * ============================================
 * 2022-02-23      JeongmyoengHong     최초 생성
 */
public class GreedyImpl implements Greedy {

    /**
     * 거스름돈 (87P)
     * 손님에게 N 원을 거슬러줘야한다.
     * 500원, 100원, 50원, 10원짜리 동전을 무한대로 가지고있다고 가정하고
     * 최소한의 동전 갯수로 거슬러주어라.
     * 단, 거스름돈의 액수는 항상 10의 배수이다.
     * */

    @Override
    public void changeMoney() {
        int change = (int) (Math.random() * 1000 + 1) * 10;
        int[] coin = new int[4];
        String[] coinName = {"500원", "100원", "50원", "10원"};
        String res = "";
        System.out.println("잔돈은 " + change + " 원");

        coin[0] = change / 500;
        change %= 500;
        coin[1] = change / 100;
        change %= 100;
        coin[2] = change / 50;
        change %= 50;
        coin[3] = change / 10;
        for (int i = 0; i < coinName.length; i++) {
            res += coinName[i] + " " + coin[i] + "개  ";
        }
        System.out.println(res + "입니다.");
    }


    /**
     * 큰수의 법칙 (92P)
     * 다양한 수로 이루어진 배열이 있다 ex)_ {3, 4, 5, 4, 5, 6}
     * 주어진 수를 M번을 더하여 가장 큰 수를 만들어라.
     * 동일한 Index의 숫자를 연속해서 K번을 초과하여 사용 할 수 없다.
     * 예를 들어, M=5, K=3 이라면 6 + 6 + 6 + 5 + 6 이 될 것이다.
     * 만약 주어진 배열이 {3, 4, 6, 6 } 이라면
     * 6이 다른 Index 이므로 6 + 6 + 6 + 6 + 6이 될 것이다.
     * */

    @Override
    public void lawOfNum() {


    }

    @Override
    public void cardGame() {

    }

    @Override
    public void toNumberOne() {

    }
}