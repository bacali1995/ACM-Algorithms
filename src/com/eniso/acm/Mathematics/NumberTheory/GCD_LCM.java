package com.eniso.acm.Mathematics.NumberTheory;

import java.io.PrintWriter;

public class GCD_LCM {

    static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static long lcm(long a, long b) {
        return a * (b / gcd(a, b));
    }

    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out);
        out.println(gcd(7, 18));
        out.println(lcm(7, 18));
        out.close();
    }

}
