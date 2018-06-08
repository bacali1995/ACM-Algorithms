package com.eniso.acm.Mathematics.Combinatorics;

import java.io.PrintWriter;
import static java.lang.Math.*;

public class FibonacciNumbers {

    static double goldenRatio = (1.0 + sqrt(5)) / 2.0;
    static long[] fibo = new long[100000];
    
    static long fibonacci(int n){
        return (long) ((pow(goldenRatio,n)-pow(-goldenRatio,-n))/sqrt(5));
    }
    
    static long fibonacci2(int n){
        if (n<2){
            fibo[n] = n;
            return fibo[n];
        }
        if (fibo[n]==0){
            fibo[n] = fibonacci2(n-1)+fibonacci2(n-2);
        }
        return fibo[n];
    }
    
    
    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out);
        fibonacci2(100);
        for (int i = 0; i < 100; i++) {
            out.println(i+"   "+fibonacci(i)+" "+fibo[i]+" "+(fibonacci(i)==fibo[i]));
        }
        out.close();
    }
}
