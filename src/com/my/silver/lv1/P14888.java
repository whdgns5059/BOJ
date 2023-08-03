package com.my.silver.lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.util.Collections.swap;

public class P14888 {

    static int[] nums;
    static String[] operators;
    static long max;
    static long min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int[] operatorCounter = new int[4];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < 4 ; i++) {
            operatorCounter[i] = Integer.parseInt(st.nextToken());
        }
        /*
        연산자 수를 실제 연산자 배열로 만들어 연산자의 순열을 구하고
        순열에 따른 숫자의 계산 결과를 출력합니다.
         */

        //연산자들의 숫자를 계산해서 연산자 배열에 넣습니다
        //ex 0 2 1 1 -> {-, -, *, /}
        operators = getOperators(operatorCounter);

        max = Long.MIN_VALUE;
        min = Long.MAX_VALUE;

        //순열을 찾아 결과를 계산하고 최대,최소를 구합니다.
        combinationOp(0, operators.length);

        System.out.println(max);
        System.out.println(min);

    }

    private static void combinationOp(int i, int length) {

        if(i == length){
            long sum = calculate(operators);
            max = Math.max(sum, max);
            min = Math.min(sum, min);
            return;
        }

        for(int j = i ; j < length ; j++){
            swap(operators, j, i);
            combinationOp(i+1, length);
            swap(operators, j, i);
        }


    }

    //순열로 만들어진 조합에 따라 결과를 계산합니다.
    private static long calculate(String[] operators) {

        long sum = nums[0];
        for(int i = 0; i < operators.length; i++){
            switch (operators[i]){
                case "+": sum += nums[i+1]; break;
                case "-": sum -= nums[i+1]; break;
                case "*": sum *= nums[i+1]; break;
                case "/": sum /= nums[i+1]; break;
            }
        }
        return sum;
    }

    private static void swap(String[] operators, int j, int i) {
        String s = operators[i];
        operators[i] = operators[j];
        operators[j] = s;
    }

    private static String[] getOperators(int[] operatorCounter) {

        List<String> operators = new ArrayList<>();
        for(int i = 0 ; i < operatorCounter[0] ; i++){
            operators.add("+");
        }
        for(int i = 0 ; i < operatorCounter[1] ; i++){
            operators.add("-");
        }
        for(int i = 0 ; i < operatorCounter[2] ; i++){
            operators.add("*");
        }
        for(int i = 0 ; i < operatorCounter[3] ; i++){
            operators.add("/");
        }
        return operators.toArray(new String[operators.size()]);
    }
}
