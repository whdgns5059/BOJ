package com.my.backjoon.silver.lv1;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class P20922 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //인덱스 i, j 두개의 포인터를 이용,
        //i는 고정하고 j는 i부터 1증가시키며 조건을 만족하는지 확인,
        //j에서 조건이 만족되지 않으면
        //해당 arr[j]가 처음으로 등장하는 위치 + 1에서 시작.
        int i = 0;
        int j = 0;
        int result = Integer.MIN_VALUE;
        Map<Integer, Integer> countMap = new HashMap<>();
        while(j < n){

            //각 원소별로 갯수를 카운팅 하기위해 map사용
            int count = countMap.getOrDefault(arr[j], 0) + 1;
            //조건을 만족할 경우(j++), 카운트 증가
            if(count <= k){
                countMap.put(arr[j], count);
                j++;

            //조건이 안맞을 경우(arr[j]가 k번째 등장하는 위치 찾아 i에 대입, 카운트 초기화
            }else{
               i = findIndex(arr, j, k);
               j = i;
               countMap = new HashMap<>();
            }

            result = Math.max(result, j - i);
        }

        bw.write(Integer.toString(result));

        br.close();
        bw.close();
    }

    private static int findIndex(int[] arr, int j, int k) {
        int counter = 0;
        int i = j;
        while(counter <= k) {
            if (arr[i--] == arr[j]) {
                counter++;
            }
        }
        //i를 K의 개수를 초과한 숫자의 인덱스 +1 로
        // 위치하기 위해 마지막 검사에서 -1이 되므로 +2를 해준다
        return i+2;

    }
}
