package com.my.silver.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class P18111 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[][] ground = new int[n][m];

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < m ; j++){
                int height = Integer.parseInt(st.nextToken());
                ground[i][j] = height;
                max = Math.max(max, height);
                min = Math.min(min, height);
            }
        }

        List<long[]> times = new ArrayList<>();
        int index = 0;
        for(int i = min ; i <= max ; i++){

            long time = narasi(ground, i, b);;

            if(time == -1){
                continue;
            }
            times.add(new long[]{time, i});
        }

        times.sort((t1, t2) -> {
            if(t1[0] == t2[0]){
                return Math.toIntExact(t2[1] - t1[1]);
            }
            return Math.toIntExact(t1[0] - t2[0]);
        });

        System.out.println(times.get(0)[0] + " " + times.get(0)[1]);

    }

    private static int narasi(int[][] ground, int target, int bag) {

        int time = 0;

        for(int i = 0 ; i < ground.length ; i++){
            for(int j = 0 ; j < ground[i].length ; j++){

                int height = ground[i][j];

                if(height > target){
                    time += (height - target) * 2;
                    bag += (height - target);
                }else if(height < target){
                    time += (target - height);
                    bag -= (target - height);
                }
            }
        }

        if(bag < 0){
            return -1;
        }

        return time;
    }
}
