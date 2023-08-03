package com.my.newbie.strings;

import java.io.*;

public class P11718 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        while(str != null){
            sb.append(str + '\n');
            str = br.readLine();
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
