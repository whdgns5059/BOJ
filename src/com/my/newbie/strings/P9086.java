package com.my.newbie.strings;

import java.util.Scanner;

public class P9086 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int count = Integer.parseInt(sc.nextLine());

        for(int i = 0; i < count; i++){
            String str = sc.nextLine();

            String s0 = Character.toString(str.charAt(0));
            String sLast = Character.toString(str.charAt(str.length()-1));

            System.out.println(s0 + sLast);
        }

    }
}
