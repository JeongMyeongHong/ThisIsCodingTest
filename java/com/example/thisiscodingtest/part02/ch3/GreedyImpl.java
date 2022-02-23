package com.example.thisiscodingtest.part02.ch3;

/**
 * packageName   :   com.example.thisiscodingtest.part02.ch3
 * fileName      :   no1
 * author        :   JeongMyeongHong
 * date          :   2022-02-23
 * desc          :  Part2 ch3.그리디
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
     * <p>
     * 조건 : N은 10~10000 사이의 10의 배수 이다.
     */
    @Override
    public void changeMoney() {
        int change = (int) (Math.random() * 1000 + 1) * 10;
        int[] coin = new int[4];
        int[] coinName = {500, 100, 50, 10};
        String res = "";
        System.out.println("잔돈은 " + change + " 원");

        for (int i = 0; i < coin.length; i++) {
            coin[i] = change / coinName[i];
            change %= coinName[i];
            res += coinName[i] + "원 " + coin[i] + "개  ";
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
     * <p>
     * 조건 : 배열의 크기는 2~1000 사이의 랜덤정수이며 각 요소는 1~10000의 랜덤 정수이다.
     * ( M 과 K 는 1~10000 의 랜덤정수)
     * <p>
     * 책은 조건이 저렇게 되어있는데 크기가 너무 커서 맞는지 모르겠음...
     * 배열의 크기 2~30, 요소 1~100
     * M 과 K 는 1~20의 랜덤정수로 변경해서 풀었음.
     */
    @Override
    public void lawOfNum() {
        int[] arr = new int[(int) (Math.random() * 29 + 2)];
        int k = (int) (Math.random() * 20 + 1); //연속 k번 까지 가능.
        int m = (int) (Math.random() * 20 + 1); //m번 더한다.
        int cnt = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) { //배열 값 입력
            arr[i] = (int) (Math.random() * 100 + 1);
        }
        for (int i = 0; i < arr.length; i++) { //배열 출력
            System.out.print(arr[i] + " ");
        }
        System.out.println("<--배열 더하는 횟수(m) : " + m + " 연속 횟수(k) : " + k + "\n최댓값 : " + max(arr)[0] + " 두번째값 : " + max(arr)[1]);


        for (int i = 0; i < m; i++) {
            if (cnt != k) {
                sum += max(arr)[0];
                cnt++;
            } else {
                sum += max(arr)[1];
                cnt = 0;
            }
        }
        System.out.println("for 돌린 sum = " + sum);


        int sum2 = max(arr)[0] * m - (max(arr)[0] - max(arr)[1]) * (m / (k + 1));
        System.out.println("간단하게 한 sum = " + sum2);
    }

    public int[] max(int[] arr) {//최댓값과 두번째 값을 얻어주는 메소드.
        int[] max = new int[2];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= max[0]) {
                max[1] = max[0];
                max[0] = arr[i];
            } else if (arr[i] >= max[1]) {
                max[1] = arr[i];
            }
        }
        return max;
    }


    /**
     * 숫자 카드 게임 (96P)
     * 1. N * M 의 형태로 카드가 놓여있다.
     * 2. 뽑고자 하는 행을 선택한다.
     * 3. 선택된 행의 카드들 중 가장 숫자를 뽑는다.
     * 4. 이때 나온 숫자는 어떠한 행을 선택해도 가장 큰 값이어야 한다.
     * 5. 출력 결과는 나올 수 있는 가장 큰 값 이다.
     * <p>
     * 조건 : N과 M 은 1~100까지의 랜덤 정수이다.
     * 각 요소들은 1~10000 까지의 랜덤 정수이다.
     * <p>
     * 책은 조건이 저렇게 되어있는데 크기가 너무 커서 맞는지 모르겠음...
     * N과 M 은 5~10까지의 랜덤 정수
     * 각 요소들은 1~1000까지의 랜덤 정수로 변경해서 문제 풀이 하였음.
     */
    @Override
    public void cardGame() {
        int[][] arr = new int[(int) (Math.random() * 6 + 5)][(int) (Math.random() * 6 + 5)];
        for (int i = 0; i < arr.length; i++) { //배열 값 입력
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (int) (Math.random() * 1000 + 1);
            }
        }
        for (int i = 0; i < arr.length; i++) { //배열 출력
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println("\t\t" + i + " 행의 최솟값 : " + minCardGame(arr)[i]); //i 행의 최솟값을 확인하기 위한 최솟값 출력
        }
        System.out.println(maxCardGame(minCardGame(arr))); //최솟값 들의 최댓값 출력
    }

    public int[] minCardGame(int[][] arr) {
        int[] min = new int[arr.length];
        for (int i = 0; i < min.length; i++) {
            min[i] = arr[i][0];
            for (int j = 1; j < arr[i].length; j++) {
                min[i] = Math.min(min[i], arr[i][j]);
            }
        }
        return min;
    }

    public int maxCardGame(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }


    /**
     * 1이 될 때까지 (99P)
     * 자연수 N 이 1이 될 때까지 아래의 과정을 반복적으로 선택 수행한다.
     * 1. N에서 1을 뺀다.
     * 2. N을 K로 나눈다.
     * 3. N을 1로 만드는 과정의 최솟값을 구하여라.
     *
     * ex)_ N = 17 K = 4 인 경우
     * 1번 과정을 수행 후 2번과정을 두번 하면
     * 17  ->  16  ->  4  ->  1  이 된다.
     * 총 실행 횟수는 3회로 N을 1로 만들 수 있는 최소 횟수가 된다.
     *
     * 조건 : N 과 K 는 2 ~ 100000 사이의 랜덤 정수이다.
     *
     * n의 값을 200~10000
     * k의 값을 2~100으로 임의 변경해서 풀이함.
     */
    @Override
    public void toNumberOne() {
        int n = (int) (Math.random() * 9801 + 200);
        int k = (int) (Math.random() * 99 + 2);
        int cnt = 0;
        System.out.println("n의 값 : " + n + "\tk의 값 : " + k);
        while (n != 1) {
            if (n % k == 0) {
                n = n / k;
                cnt++;
                System.out.println("2번 연산 결과 : "+n);
            } else {
                n--;
                cnt++;
                System.out.println("1번 연산 결과 : "+n);
            }
        }
        System.out.println("연산 횟수는 " + cnt + "회 입니다.");
    }
}