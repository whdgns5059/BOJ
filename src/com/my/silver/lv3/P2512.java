package com.my.silver.lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2512 {

    static BufferedReader br;
    static int n;
    static int[] budgets;
    static int totalBudget;
    static int max;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        budgets = input();
        totalBudget = Integer.parseInt(br.readLine());

        /*이분 탐색을 이용하여 정답을 찾고자 합니다.
        최소 0, 최대값은 문제의 1번 조건때문에 INF가 아니라 예산의 최대값+1 로 설정하였습니다.
            이분 탐색을 이용하면 T에서F로 혹은 그 반대로 변화하는 시점에서의 값을 찾는건데
            최댓값을 예산의 가장큰값+1 로 설정하여 그 이상의 답이 나오지 않도록 하였습니다.
        */
        int low = 0;
        int high = max+1;

        while(low + 1 < high){

            int mid = (low + high) / 2;

            if(check(mid)){
                low = mid;
            }else{
                high = mid;
            }
        }

        System.out.println(low);
    }

    /*
    경계지점의 조건을 중간값과 예산의 합이 전체 예산보다 작을경우로 하였습니다.
     */
    private static boolean check(int mid) {
        int sum = 0;
        for(int budget : budgets){
            sum += Math.min(budget, mid);
        }
        return sum <= totalBudget;
    }

    private static int[] input() throws IOException {
        int[] result = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i ++){
            int num = Integer.parseInt(st.nextToken());
            result[i] = num;
            max = Math.max(num, max);
        }
        return result;
    }
}
