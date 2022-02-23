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