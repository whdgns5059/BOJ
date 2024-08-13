package com.my.backjoon.bronze.lv3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P31907 {


    static char[][] gist = {
        {'0', '0', '0', '0', '0'},
        {'0', 'G', '.', '.', '.'},
        {'0', '.', 'I', '.', 'T'},
        {'0', '.', '.', 'S', '.'},
    };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        char[][] picture = new char[k * 3 + 1][k * 4 + 1];

        for (int i = 1; i < picture.length; i++) {
            for (int j = 1; j < picture[i].length; j++) {

                picture[i][j] = getCharFromGist(i, j, k);

            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i < picture.length; i++) {
            for (int j = 1; j < picture[i].length; j++) {
                bw.append(picture[i][j]);
            }
            bw.append("\n");
        }

        bw.flush();
        bw.close();


    }

    private static char getCharFromGist(int i, int j, int k) {

        int x = (i + k - 1) / k;
        int y = (j + k - 1) / k;
        return gist[x][y];

    }

}
