package com.eniso.acm.Mathematics.NumberTheory;

import java.io.*;
import java.util.*;

public class PrimeNumbers {

    static BitSet isPrime = new BitSet(10000000);
    static ArrayList<Long> primes = new ArrayList<>();

    static void sieve() {
        isPrime.set(0);
        isPrime.set(1);
        for (long i = 2; i < isPrime.size(); i++) {
            if (!isPrime.get((int) i)) {
                primes.add(i);
                for (long j = 2 * i; j < isPrime.size(); j += i) {
                    isPrime.set((int) j);
                }
            }
        }
    }

    static boolean isPrime(long n) {
        if (n < isPrime.size()) {
            return !isPrime.get((int) n);
        }
        for (int i = 0; i < primes.size(); i++) {
            long u = primes.get(i);
            if (u * u > n) {
                break;
            }
            if (n % u == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out);
        sieve();
        out.println(isPrime(136117223861L));
        out.close();
    }

}
