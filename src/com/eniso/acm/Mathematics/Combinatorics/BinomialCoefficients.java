package com.eniso.acm.Mathematics.Combinatorics;

import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class BinomialCoefficients {

    static long[] fact = new long[100];

    static long CnkRecursive(int n, int k) {
        if (k == 0 || k == n) {
            return 1L;
        }
        return CnkRecursive(n - 1, k - 1) + CnkRecursive(n - 1, k);
    }

    static long CnkIterative(int n, int k) {
        long mod = (long) (1e9 + 7);
        long res = 1;
        long res2 = 1;
        if (k > n - k) {
            k = n - k;
        }
        for (int i = 0; i < k; ++i) {
            res *= (n - i);
            res2 *= (i + 1);
            res %= mod;
            res2 %= mod;
        }
        return (res / res2) % mod;
    }

    static long AnkIterative(int n, int k) {
        long res = 1;
        for (int i = n - k + 1; i < n + 1; ++i) {
            res *= i;
        }
        return res;
    }

    static long fact(int n) {
        if (n < 2) {
            return 1;
        }
        if (fact[n] == 0) {
            fact[n] = n * fact(n - 1);
        }
        return fact[n];
    }

    static long nbrCombinaison(int n, int... k) {
        long res = fact(n);
        for (int i = 0; i < k.length; i++) {
            res /= fact(k[i]);
        }
        return res;
    }

    /*
    * Time Complexity: O(n*k)
    * Auxiliary Space: O(n*k)
     */
    static long CnkDpMatrix(int n, int k) {
        long[][] c = new long[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= min(i, k); j++) {
                if (j == 0 || j == i) {
                    c[i][j] = 1;
                } else {
                    c[i][j] = c[i - 1][j - 1] + c[i - 1][j];
                }
            }
        }
        return c[n][k];
    }

    /*
    * Time Complexity: O(n*k)
    * Auxiliary Space: O(k)
     */
    static long CnkDpArray(int n, int k) {
        long[] c = new long[k + 1];
        c[0] = 1;
        for (int i = 0; i <= n; i++) {
            for (int j = min(i, k); j > 0; j--) {
                c[j] = c[j] + c[j - 1];
            }
        }
        return c[k];
    }

    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out);
        int n = 3, k = 1;
//        out.println(CnkRecursive(n, k));
        out.println(CnkIterative(n + k - 1, k - 1));
//        out.println(CnkDpMatrix(n, k));
//        out.println(CnkDpArray(n, k));
//        out.println(AnkIterative(n, k));
//        out.println(nbrCombinaison(5, 3));
        out.close();
    }

}
