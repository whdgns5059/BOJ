package com.my.newbie.fastIO;

import java.io.*;

public class P15552 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());

        for(int i = count; i > 0; i--){

            String line = br.readLine();
            String[] strArr = line.split(" ");
            bw.write(Integer.parseInt(strArr[0]) + Integer.parseInt(strArr[1]) + "\n");

        }

        br.close();
        bw.flush();
        bw.close();
    }
}
