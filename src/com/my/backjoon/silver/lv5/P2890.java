package com.my.backjoon.silver.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class P2890 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        Kayak[] kayaks = new Kayak[9];
        int count = 0;

        for (int i = 0; i < r; i++) {
            Kayak kayak = new Kayak(br.readLine().toCharArray(), c);
            if (kayak.hasNo()) {
                kayaks[count++] = kayak;
            }
        }

        Arrays.sort(kayaks, Comparator.comparingInt(Kayak::getPosition).reversed());

        int rank = 1;
        kayaks[0].rank = rank++;
        for (int i = 1; i < kayaks.length; i++) {
            if (kayaks[i].getPosition() < kayaks[i - 1].getPosition()) {
                kayaks[i].rank = rank++;
            } else {
                kayaks[i].rank = rank - 1;
            }

        }

        Arrays.sort(kayaks, Comparator.comparingInt(Kayak::getNo));

        for (Kayak kayak : kayaks) {
            System.out.println(kayak.rank);
        }


    }

    static class Kayak {

        private int no;
        private char[] lain;
        private int position;
        public int rank;

        public Kayak(char[] input, int c) {

            for (int i = 0; i < c; i++) {
                if ('0' < input[i] && input[i] <= '9') {
                    this.no = Character.getNumericValue(input[i]);
                    break;
                }
            }

            this.lain = new char[c - 2];
            for (int i = 1; i < c - 1; i++) {
                this.lain[i - 1] = input[i];
            }

            for (int i = lain.length - 1; i >= 0; i--) {
                if (lain[i] != '.') {
                    this.position = i;
                }
            }

        }

        public boolean hasNo() {
            return no > 0;
        }

        public int getPosition() {
            return position;
        }

        public int getNo() {
            return this.no;
        }

    }

}


