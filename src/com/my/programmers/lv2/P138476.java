package com.my.programmers.lv2;

import java.util.*;

public class P138476 {


    int solution(int k, int[] tangerine){

        Map<Integer, Integer> map = new HashMap<>();
        for(int t : tangerine){
            map.put(t, map.getOrDefault(t, 0) + 1);
        }

        List<Integer> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1, o2) -> {
            return map.get(o1).compareTo(map.get(o2)) * -1;
        });

        int count = 0;
        int sum = 0;
        for(Integer i : keySet){
            if(sum < k){
                sum += map.get(i);
                count++;
            }
        }

        return count;
    }




}
