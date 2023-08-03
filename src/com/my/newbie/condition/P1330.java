package com.my.newbie.condition;

import java.util.Scanner;

public class P1330 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int A, B;
        A = sc.nextInt();
        B = sc.nextInt();

        String result;
        if(A < B){
            result = "<";
        }else if(A > B){
            result = ">";
        }else{
            result = "==";
        }

        System.out.println(result);


    }
}
