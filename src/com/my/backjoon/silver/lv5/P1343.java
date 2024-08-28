package com.my.backjoon.silver.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1343 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] board = br.readLine().toCharArray();

        int i = 0;

        while (i < board.length) {

            int counter = 0;
            for (int j = i; j < i + 4; j++) {
                if (j < board.length && board[j] == 'X') {
                    counter++;
                } else {
                    break;
                }
            }

            if (counter == 4) {
                for (int j = i; j < i + counter; j++) {
                    board[j] = 'A';
                }
                i += 4;
            } else if (counter == 2) {
                for (int j = i; j < i + counter; j++) {
                    board[j] = 'B';
                }
                i += 2;
            } else if (board[i] == '.') {
                i++;
            } else {
                System.out.println("-1");
                System.exit(0);
            }

        }

        System.out.println(board);


    }

}
