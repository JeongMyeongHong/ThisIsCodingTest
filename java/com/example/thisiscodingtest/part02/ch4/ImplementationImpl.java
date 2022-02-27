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
        String coordinates = scanner.next();
        int x = coordinates.charAt(0) - 96;
        int y = coordinates.charAt(1) - 48;
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
//        int n = (int) (Math.random() * 48 + 3);
//        int m = (int) (Math.random() * 48 + 3);
        int n = (int) (Math.random() * 6 + 5);
        int m = (int) (Math.random() * 6 + 5);

        int[][] map = new int[n][m];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (i == 0 || i == map.length - 1 || j == 0 || j == map[i].length - 1) map[i][j] = 1;
                else map[i][j] = (int) (Math.random() * 2);
            }
        }
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + "  ");
            }
            System.out.println();
        }
    }

    /**
     * 게임 개발(118p)
     * N * M 크기의 공간이 있다. 각 칸은 육지 또는 바다이다.
     * 캐릭터는 동서남북중 한곳을 바라보고 있다.
     * 맵의 각 칸은 (A, B)로 나타내며 A는 북쪽으로부터 떨어진 칸의 수, B는 서쪽으로부터 떨어진 칸의 수이다.
     * 상하좌우로 움직일 수 있고 바다로 되어있는 공간에는 갈 수 없다.
     * 캐릭터의 움직임을 설정하기 위해 정해놓은 매뉴얼은 아래와 같다.
     * 1. 현재 위치에서 현재 방향을 기준으로 왼쪽방향(반시계 방향으로 90도 회전)부터 차례대로 갈 곳을 정한다.
     * 2. 캐릭터의 바로 왼쪽 방향에 아직 가보지 안ㄶ은 칸이 존재한다면, 왼쪽방향으로 회전한 다음 왼쪽으로 한 칸을 전진한다.
     *    왼쪽 방향에 가보지 않은 칸이 없다면 왼쪽방향으로 회전만 한 후 1단계로 돌아간다.
     * 3. 만약 네 방향 모두 이미 가본 칸이거나 바다인경우, 바라보는 방향을 유지한 채로 한칸 뒤로 이동 후 1단계로 돌아간다.
     *    이때 뒤쪽 방향이 바다인 칸이라 뒤로 갈 수 없을 경우에는 움직임을 멈춘다.
     *
     * (책과는 다른 입력조건)
     * 입력조건 1. 공간의 크기 (세로 N, 가로 M)에 3~50 사이의 랜덤숫자를 할당한다.
     *        2. 맵의 정보를 입력한다.(맵의 크기만큼 0(육지),1(바다) 랜덤으로 할당한다.)
     *           맵의 외각은 항상 바다로 되어있다.
     *        3. 캐릭터가 있는 칸의 좌표 (A, B)와 바라보고 있는 방향 d를 각각 공백으로 입력한다. (0-북, 1-동, 2-남, 3-서)
     *           (공백으로 구분하기 힘들다면 엔터로 구분)
     *           게임 캐릭터의 최초 위치는 항상 육지이다.
     *       ex) N,M은 랜덤.   N=5, M=6
     *           맵의 정보는 랜덤.
     *                1 1 1 1 1 1
     *                1 1 0 1 0 1
     *                1 0 0 0 1 1
     *                1 1 0 0 0 1
     *                1 1 1 1 1 1
     *           캐틱터의 생성 좌표 및 방향 ( (1,1) 에 북쪽을 바라본다.)
     *                1 1 0
     * 출력조건 1. 이동을 마친 후 캐릭터가 방문한 칸의 수를 출력한다.
     *      ex) 3
     * */
}
