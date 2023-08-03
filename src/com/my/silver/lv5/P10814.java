package com.my.silver.lv5;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P10814 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        People[] arr = new People[n];
        for(int i = 0 ; i < n ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            People p = new People(st.nextToken(), st.nextToken());
            arr[i] = p;
        }

        Arrays.sort(arr);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(People p : arr){
            bw.write(p.toString());
        }
        br.close();
        bw.flush();
        br.close();


    }

    private static class People implements Comparable{
        int age;
        String name;

        People(String age, String name){
            this.age = Integer.parseInt(age);
            this.name = name;
        }

        @Override
        public int compareTo(Object o) {

            People p = (People) o;
            if(this.age != p.age){
                return age - p.age;
            }
            return 0;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.age);
            sb.append(" ");
            sb.append(this.name);
            sb.append("\n");
            return sb.toString();
        }
    }
}
