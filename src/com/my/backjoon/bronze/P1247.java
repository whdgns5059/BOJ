package com.my.backjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class P1247 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] result = new String[3];
        int resultCount = 0;

        String count = br.readLine();

        while(count != null){

            int counter = Integer.parseInt(count);

            BigInteger sum = new BigInteger("0");
            for(int i = 0 ; i < counter ; i++){
                sum = sum.add(BigInteger.valueOf(Long.parseLong(br.readLine())));
            }

            if(sum.compareTo(BigInteger.ZERO) > 0 ){
                result[resultCount++] = "+";
            }else if(sum.compareTo(BigInteger.ZERO) < 0){
                result[resultCount++] = "-";
            }else{
                result[resultCount++] = "0";
            }

            count = br.readLine();

        }

        for (String s: result) {
            System.out.println(s);
        }

        br.close();
    }
}
