package com.my.backjoon.gold.lv5;

import java.io.*;
import java.util.*;

public class P2800 {

    static String expression;
    static List<int[]> braketList;
    static Set<String> resultSet;
    static List<String> result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        expression = br.readLine();
        result = new ArrayList<>();
        resultSet = new HashSet<>();

        /*
        총 경우의 수는 2^n -1 개.
        각각의 괄호쌍의 위지를 기록해서 각 경우의 수마다(조합)
        괄호의 위치를 2차원 배열로 저장하면 좋을듯 ex( {{0.6},{3,5}}
        조합에 맞추서 지우고 출력 반복
         */

        //스택에 "("를 posh하고 ")"를 pop하면서
        //각 괄호 쌍의 index를 배열에 저장합니다.
        Stack<int[]> braketStack = new Stack<>();
        braketList = new ArrayList<>();
        for(int i = 0 ; i < expression.length() ; i++){
            if(expression.charAt(i) == '('){
                braketStack.push(new int[]{i, -1});
            }else if(expression.charAt(i) == ')'){
                int[] bracket = braketStack.pop();
                bracket[1] = i;
                braketList.add(bracket);
            }
        }


        //괄호제거의 경우의 수를 조합 알고리즘을 통해 구합니다.
        boolean[] braketComb = new boolean[braketList.size()];
        for(int i = 0 ; i < braketList.size() ; i++){
            combination(braketComb , 0, i);
        }

        //정렬 후 출력
        result.addAll(resultSet);
        Collections.sort(result);

        for(String s : result){
            bw.write(s + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }

    private static void combination(boolean[] braketComb, int start, int r) {
        if(r == 0){

            //경우의 수마다 문자열을 변경하여 Set에 저장합니다(중복방지)
            //문변경시에 기존문자열의 index가 바뀌어 쓰이지 않는 특문으로 변경후
            //완료되면 제거하였습니다.
            StringBuilder sb = new StringBuilder((expression));
            for(int i = 0 ; i < braketComb.length ; i++){
                if(!braketComb[i]){
                    int[] braket = braketList.get(i);
                    sb.replace(braket[0], braket[0]+1, "!");
                    sb.replace(braket[1], braket[1]+1, "!");
                }
            }

            resultSet.add(sb.toString().replaceAll("!",""));

            return;
        }
        for(int i = start; i < braketList.size() ; i++){
            braketComb[i] = true;
            combination(braketComb, i + 1, r - 1);
            braketComb[i] = false;
        }
    }

}
