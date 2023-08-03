package com.my.bronze.lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1546 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int[] points = new int[n];

        for(int i = 0 ; i < n ; i++){
            points[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for(int point : points){
            if(max < point){
                max = point;
            }
        }

        double[] newPoints = new double[n];
        for(int i = 0 ; i < n ; i++){
            newPoints[i] = (double)points[i] / max * 100;
        }
        double avg = 0;
        double total = 0;
        for(double newPoint : newPoints){
            total += newPoint;
        }

        System.out.println(total / n);
    }
}
