package com.my.backjoon.silver.lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P2108 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] nums = new int[n];

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int total = 0;
        for(int i = 0 ; i < n ; i++){
            int num = Integer.parseInt(br.readLine());
            nums[i] = num;
            max = Math.max(max, num);
            min = Math.min(min, num);
            total += num;
        }

        Arrays.sort(nums);

        long avg = Math.round((double)total / n);
        int center = getCenter(nums);
        int mode = getMode(nums);
        int range = max - min;

        System.out.println(avg);
        System.out.println(center);
        System.out.println(mode);
        System.out.println(range);

    }

    private static int getMode(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<>();

        int max = Integer.MIN_VALUE;
        for(int i : nums){
            int count = counter.getOrDefault(i, 0) + 1;
            max = Math.max(max, count);
            counter.put(i, count);
        }
        List<Integer> result = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : counter.entrySet()){
            if(entry.getValue() == max){
                result.add(entry.getKey());
            }
        }

        result.sort(Integer::compareTo);
        return result.size() > 1 ? result.get(1) : result.get(0);
    }

    private static int getCenter(int[] nums) {
        if(nums.length % 2 == 1){
            return nums[nums.length / 2];
        }

        int n1 = nums[nums.length / 2];
        int n2 = nums[nums.length / 2 + 1];
        return (n1 + n2) / 2;

    }

}
