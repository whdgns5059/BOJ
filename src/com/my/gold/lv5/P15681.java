package com.my.gold.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P15681 {


    public static List<List<Integer>> connect;
    public static int[] counter;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        connect = new ArrayList<>();
        for(int i = 0 ; i <= n ; i++){
            connect.add(new ArrayList<>());
        }

        for(int i = 1; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
           connect.get(u).add(v);
           connect.get(v).add(u);
        }

        int[] query = new int[q];
        for(int i = 0 ; i < q ; i++){
            query[i] = Integer.parseInt(br.readLine());
        }

        counter = new int[n+1];

        dfs(r,-1);
        StringBuilder sb= new StringBuilder();
        for(int i : query){
            sb.append(counter[i]).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void dfs(int r, int prev){

        counter[r] = 1;

        for(int i : connect.get(r)){
            if(i == prev){
                continue;
            }
            dfs(i, r);
            counter[r] += counter[i];
        }



    }

    static void regex(String string){
        Matcher matcher = Pattern.compile("//?\\n").matcher(string);
        String result = matcher.group();

    }


}
