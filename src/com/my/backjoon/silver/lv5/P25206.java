package com.my.backjoon.silver.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class P25206 {

    static Map<String, Double> pointMap = new HashMap<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        pointMap.put("A+", 4.5);
        pointMap.put("A0"	,4.0);
        pointMap.put("B+"	,3.5);
        pointMap.put("B0"	,3.0);
        pointMap.put("C+"	,2.5);
        pointMap.put("C0"	,2.0);
        pointMap.put("D+"	,1.5);
        pointMap.put("D0"	,1.0);
        pointMap.put("F"	,0.0);

        String str;
        double gradePoint = 0;
        double studentPoint = 0;
        while((str = br.readLine()) != null && !str.isEmpty()){

            StringTokenizer st = new StringTokenizer(str);
            String subject = st.nextToken();
            double subjectPoint = Double.parseDouble(st.nextToken());

            String pointStr = st.nextToken();
            double point = 0;
            if("P".equals(pointStr)){
                continue;
            }else{
                point = pointMap.get(pointStr);
            }

             gradePoint += subjectPoint * point;
             studentPoint += subjectPoint;

        }

        System.out.println(gradePoint / studentPoint);


    }

}
