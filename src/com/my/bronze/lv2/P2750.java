package com.my.bronze.lv2;

import java.io.*;
import java.util.Arrays;

public class P2750 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        for(int i = 0 ; i < n ; i++){
            nums[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        Arrays.sort(nums);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0 ; i < n ; i++){
            bw.write(nums[i] + "\n");
        }
        bw.flush();
        bw.close();

    }
}
