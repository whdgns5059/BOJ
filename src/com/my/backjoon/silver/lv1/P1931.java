package com.my.backjoon.silver.lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class P1931 {

    void solution(int n, long[][] meetings){

        //그리디 알고리즘 이용, 회의의 종료시간이 중요함.
        //회의 시간을 종료시간, 시작시간 순으로 정렬한다.
        //이번회의 종료시간 <= 다음회의 시작시간 이면 추가
        Arrays.sort(meetings,(a1, a2) -> {
            if(a1[1] == a2[1])
                return Math.toIntExact(a1[0] - a2[0]);
            return Math.toIntExact(a1[1] - a2[1]);
        });

        List<long[]> results = new ArrayList<>();
        results.add(meetings[0]);
        for(int i = 1; i < n ; i++){
            long endTime = results.get(results.size()-1)[1];
            if(meetings[i][0] >= endTime){
                results.add(meetings[i]);
            }
        }

        System.out.println(results.size());
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] meetings = new long[n][2];
        for(int i = 0 ; i < n ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            meetings[i] = new long[]{start, end};
        }
        new P1931().solution(n, meetings);

        br.close();
    }

}
