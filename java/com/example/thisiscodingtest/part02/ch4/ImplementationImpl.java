package com.example.thisiscodingtest.part02.ch4;

import java.util.Scanner;

/**
 * packageName   :   com.example.thisiscodingtest.part02.ch4
 * fileName      :   ImplementationImpl
 * author        :   JeongMyeongHong
 * date          :   2022-02-24
 * desc          :
 * ============================================
 * DATE             AUTHOR              NOTE
 * ============================================
 * 2022-02-24      JeongmyoengHong     최초 생성
 */
public class ImplementationImpl implements Implementation {


    @Override
    public void lrud(Scanner scanner) {
        System.out.println("맵의 크기 n을 입력하세요");
        int n = scanner.nextInt(); //맵의 크기 지정.
        System.out.println("이동 계획을 입력하세요");
        String plan = scanner.next(); //LRUD 입력.
        int indexX = 0;
        int indexY = 0;
        for (int i = 0; i < plan.length(); i++) {
            switch (plan.charAt(i)) {
                case 'L':
                    if (indexX != 0) indexX -= 1;
                    break;
                case 'R':
                    if (indexX != n) indexX += 1;
                    break;
                case 'U':
                    if (indexY != 0) indexY -= 1;
                    break;
                case 'D':
                    if (indexY != n) indexY += 1;
                    break;
                default:
                    System.out.println("LRUD가 아닙니다.");
            }
        }
        System.out.println((indexY + 1) + " " + (indexX + 1));
    }

    @Override
    public void time(Scanner scanner) {
        int n = scanner.nextInt();
        int cnt = 0;
        for (int i = 0; i <= n; i++) {
            if (i % 10 == 3) {//시에 3이 포함될 때
                cnt += 3600;
            } else {//시에 3이 포함되지 않을때
                for (int j = 0; j < 60; j++) {
                    if (j / 10 == 3 || j % 10 == 3) {//분에 3이 포함될 때
                        cnt += 60;
                    } else {//분에 3이 포함되지 않을때
                        cnt += 15;//1분에 3이 포함되는 경우의 수는 15개.
//                        for (int k = 0; k < 60; k++) {//초에 3이 포함될 때
//                            if (k / 10 == 3 || k % 10 == 3) cnt++;
//                        }
                    }
                }
            }
        }
        System.out.println(cnt);
    }

    @Override
    public void knight(Scanner scanner) {
        System.out.println("나이트의 현재 위치를 입력하세요 (a1~h8)");
        String Coordinates = scanner.next();
        int x = Coordinates.charAt(0) - 96;
        int y = Coordinates.charAt(1) - 48;
        if (x > 4) x = 9 - x;
        if (y > 4) y = 9 - y; //정사각형이므로 한 부분만 해주면 된다.

        if (x > 2 && y > 2) {
            System.out.println("8");
        } else if (x + y == 2) {
            System.out.println("2");
        } else if (x + y == 3) {
            System.out.println("3");
        } else if (x == 1 || y == 1 || x + y == 4) {
            System.out.println("4");
        } else {
            System.out.println("6");
        }
    }

    @Override
    public void devGame(Scanner scanner) {

    }
}
