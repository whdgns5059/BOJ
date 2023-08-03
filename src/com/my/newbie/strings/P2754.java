package com.my.newbie.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2754 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        char grade = s.charAt(0);


        double point = 0;

        if(grade == 'A'){
            point = 4;
        }else if(grade == 'B'){
            point = 3;
        }else if(grade == 'C'){
            point = 2;
        }else if(grade == 'D'){
            point = 1;
        }else{
            point = 0.0;
            System.out.println(point);
            return;
        }

        char detail = s.charAt(1);
        if(detail == '+'){
            point += 0.3;
        }else if(detail == '-'){
            point -= 0.3;
        }

        System.out.println(point);

    }
}
