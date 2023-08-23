package com.my.backjoon.gold.lv4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class P20166 {

    static int N, M;
    static String[][] grid;
    static Map<String, Integer> counter;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        grid = new String[N][M];
        for(int i = 0 ; i < N ; i++){
            String str = br.readLine();
            for(int j = 0 ; j < M ; j++){
                 grid[i][j] = Character.toString(str.charAt(j));
            }
        }
        //모든 만들 수 있는 문자열의 갯수를 저장할 Map
        counter = new HashMap<>();

        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                dfs(i,j, "");
            }
        }


        //신이 좋아하는 문자열에 맞춰서 값 가져와 출력
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < k; i++){
            String str = br.readLine();
            int result = counter.getOrDefault(str, 0);
            sb.append(result).append("\n");
        }
        System.out.println(sb.toString());
    }

    //dfs 순회함에 있어서 방문순서가 다른면 다른 경우이므로
    //방문여부를 확인 할 필요 없이 문자열을 더해서 map에 갯수를 저장한다
    private static void dfs(int n, int m, String s) {
        if(s.length() >= 5){
            return;
        }

        s += grid[n][m];
        counter.put(s, counter.getOrDefault(s, 0) + 1);

        //8방향 격자로 진행
        for(int i = 0 ; i < 8; i++){
            int dn = getDn(n, i);
            int dm = getDm(m, i);
            dfs(dn, dm, s);
        }
    }

    //N,M에 따른 환형 인덱스 구하기
    private static int getDn(int n, int i) {
        int r = n + dx[i];
        if(r < 0) return N-1;
        if(r >= N) return 0;
        return r;
    }

    private static int getDm(int m, int i) {
        int r = m + dy[i];
        if(r < 0) return M-1;
        if(r >= M) return 0;
        return r;
    }

}
