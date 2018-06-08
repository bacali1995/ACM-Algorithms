package com.eniso.acm.Mathematics.NumberTheory;

import java.io.PrintWriter;
import java.util.*;

public class ModifiedSieve {

    static int MAXN = (int) 1e7;
    static int[] numDiffPF = new int[MAXN];
    static ArrayList<Long> primes = new ArrayList<>();

    static void modifiedSieve() {
        for (int i = 2; i < MAXN; i++) {
            if (numDiffPF[i] == 0) {
                for (int j = i; j < MAXN; j += i) {
                    numDiffPF[j]++;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out);
        modifiedSieve();
        for (int i = 1; i < 20; i++) {
            out.println(i+" "+numDiffPF[i]);
        }
        out.close();
    }
}
