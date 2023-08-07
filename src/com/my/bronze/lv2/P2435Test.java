package com.my.bronze.lv2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P2435Test {

    P2435 p;
    int n;
    int k;
    int[] arr;

    @BeforeEach
    void setUp() {
        p = new P2435();

    }

    @Test
    void solve() {
        n = 10;
        k = 2;
        arr = new int[]{3, -2, -4, -9, 0, 3, 7, 13, 8, -3};
        assertEquals(21, p.solve(n, k, arr));
    }

    @Test
    void solve2() {
        n = 10;
        k = 1;
        arr = new int[]{3, -2, -4, -9, 0, 3, 7, 13, 8, -3};
        assertEquals(13, p.solve(n, k, arr));
    }

    @Test
    void solve3() {
        arr = new int[]{1, 2};
        n = arr.length;
        k = 2;

        assertEquals(3, p.solve(n, k, arr));
    }
}