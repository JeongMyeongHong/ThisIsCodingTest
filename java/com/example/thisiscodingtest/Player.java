package com.example.thisiscodingtest;

import com.example.thisiscodingtest.part02.ch3.Greedy;
import com.example.thisiscodingtest.part02.ch3.GreedyImpl;
import com.example.thisiscodingtest.part02.ch4.Implementation;
import com.example.thisiscodingtest.part02.ch4.ImplementationImpl;

import java.util.Scanner;

/**
 * packageName   :   com.example.thisiscodingtest
 * fileName      :   player
 * author        :   JeongMyeongHong
 * date          :   2022-02-23
 * desc          :
 * ============================================
 * DATE             AUTHOR              NOTE
 * ============================================
 * 2022-02-23      JeongmyoengHong     최초 생성
 */
public class Player {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Greedy greedy = new GreedyImpl();
//        greedy.toNumberOne();
        Implementation implementation = new ImplementationImpl();
        implementation.devGame(scanner);
    }
}
