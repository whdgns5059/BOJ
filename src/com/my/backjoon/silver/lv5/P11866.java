package com.my.backjoon.silver.lv5;

import java.util.*;

public class P11866 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            list.add(i+1);
        }

        int i = -1;
        List<Integer> results = new ArrayList<>();
        int resultI = 0;
        while(list.size() > 0){

            if(i + k >= list.size()){
                i = (i + k) % list.size();
            }else{
                i += k;
            }
            results.add(list.get(i));
            list.remove(i--);

        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for(int r : results){
            sb.append(r).append(", ");
        }
        sb.delete(sb.length()-2, sb.length()).append(">");
        System.out.println(sb.toString());

    }
}
