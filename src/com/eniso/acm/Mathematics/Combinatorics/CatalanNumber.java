package com.eniso.acm.Mathematics.Combinatorics;

import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class CatalanNumber {

    static long CNRecursive(int n) {
        long res = 0;
        if (n <= 1) {
            return 1;
        }
        for (int i = 0; i < n; i++) {
            res += CNRecursive(i) * CNRecursive(n - i - 1);
        }
        return res;
    }

    static long CNDP(int n) {
        long[] catalan = new long[n + 1];
        catalan[0] = catalan[1] = 1;
        for (int i = 2; i <= n; i++) {
            catalan[i] = 0;
            for (int j = 0; j < i; j++) {
                catalan[i] += catalan[j] * catalan[i - j - 1];
            }
        }
        return catalan[n];
    }

    static long CnkIterative(int n, int k) {
        long res = 1;
        if (k > n - k) {
            k = n - k;
        }
        for (int i = 0; i < k; ++i) {
            res *= (n - i);
            res /= (i + 1);
        }
        return res;
    }

    static long CNcnk(int n) {
        long c = CnkIterative(2 * n, n);
        return c / (n + 1);
    }

    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out);
        int n = 9;
        out.println(CNRecursive(n));
        out.println(CNDP(n));
        out.println(CNcnk(n));
        out.close();
    }
}
