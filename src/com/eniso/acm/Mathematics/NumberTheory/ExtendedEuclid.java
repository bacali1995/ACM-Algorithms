package com.eniso.acm.Mathematics.NumberTheory;

import java.io.PrintWriter;
import static java.lang.Math.*;

public class ExtendedEuclid {

    static long x;
    static long y;
    static long d;

    static void extendedEuclid(int a, int b) {
        if (b == 0) {
            x = 1;
            y = 0;
            d = a;
            return;
        }
        extendedEuclid(b, a % b);
        long x1 = y;
        long y1 = x - (a / b) * y;
        x = x1;
        y = y1;
    }

    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out);
        long a = 25;
        long b = 18;
        long c = 839;
        extendedEuclid(25, 18);
        if (c % d != 0) {
            out.println("Pas de solution!");
        } else {
            x *= c;
            y *= c;
            long n1 = (long) ceil((double) -x / b);
            long n2 = (long) floor((double) y / a);
            if (n2 < n1) {
                out.println("Pas de solution!");
            } else {
                x = x + (b * n1) / d;
                y = y - (a * n1) / d;
                out.println(x + " " + y);
            }
        }
        out.close();
    }

}
