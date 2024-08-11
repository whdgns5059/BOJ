package com.my.backjoon.bronze.lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P28702 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = new String[3];
        str[0] = br.readLine();
        str[1] = br.readLine();
        str[2] = br.readLine();

        int number = 0;
        int count = 0;
        for(int i = 0 ; i < 3 ; i++){
            if(isNumber(str[i])){
                number = Integer.parseInt(str[i]);
                count = 3 - i;
                break;
            };
        }

        int result = number + count;

        if(result % 3 != 0 && result % 5 != 0){
            System.out.println(result);
        }else if(result % 3 != 0 && result % 5 == 0){
            System.out.println("Buzz");
        }else if(result % 3 == 0 && result % 5 != 0){
            System.out.println("Fizz");
        }else if(result % 3 == 0 && result % 5 == 0) {
            System.out.println("FizzBuzz");
        }



    }

    private static boolean isNumber(String s) {

        try{
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }


}
