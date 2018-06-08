package com.eniso.acm.Mathematics.NumberTheory;

import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class PrimeFactors {

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

    static Map<Long, Integer> primeFactors(long n) {
        Map<Long, Integer> res = new HashMap<>();
        long index = 0;
        long PF = primes.get((int) index);
        while (PF * PF <= n) {
            while (n % PF == 0) {
                n /= PF;
                if (!res.containsKey(PF)) {
                    res.put(PF, 1);
                } else {
                    res.put(PF, res.get(PF) + 1);
                }
            }
            PF = primes.get((int) ++index);
        }
        if (n != 1L) {
            if (!res.containsKey(n)) {
                res.put(n, 1);
            } else {
                res.put(n, res.get(n) + 1);
            }
        }
        return res;
    }

    static long gcd(Map<Long, Integer> map1, Map<Long, Integer> map2) {
        Map<Long, Integer> res = new HashMap<>();
        for (Long key : map1.keySet()) {
            if (map2.containsKey(key)) {
                res.put(key, min(map1.get(key), map2.get(key)));
            }
        }
        return getVal(res);
    }

    static long lcm(Map<Long, Integer> map1, Map<Long, Integer> map2) {
        Map<Long, Integer> res = new HashMap<>();
        for (Long key : map1.keySet()) {
            if (map2.containsKey(key)) {
                res.put(key, max(map1.get(key), map2.get(key)));
            } else {
                res.put(key, map1.get(key));
            }
        }
        for (Long key : map2.keySet()) {
            if (!map1.containsKey(key)) {
                res.put(key, map2.get(key));
            }
        }
        return getVal(res);
    }

    static long getVal(Map<Long, Integer> map) {
        long res = 1;
        for (Long key : map.keySet()) {
            res *= pow(key, map.get(key));
        }
        return res;
    }

    public static long pow(long a, int b) {
        long result = 1;
        while (b > 0) {
            if (b % 2 != 0) {
                result *= a;
                b--;
            }
            a *= a;
            b /= 2;
        }
        return result;
    }

    static long sumDiv(long n) {
        Map<Long, Integer> map = primeFactors(n);
        long ans = 1;
        for (Long key : map.keySet()) {
            ans *= (pow(key, map.get(key) + 1) - 1) / (key - 1);
        }
        return ans;
    }

    static long numDiv(long n) {
        Map<Long, Integer> map = primeFactors(n);
        long ans = 1;
        for (Long key : map.keySet()) {
            ans *= (map.get(key) + 1);
        }
        return ans;
    }

    static long sumPF(long n) {
        Map<Long, Integer> map = primeFactors(n);
        long ans = 0;
        for (Long key : map.keySet()) {
            ans += key * map.get(key);
        }
        return ans;
    }

    static long numDiffPF(long n) {
        return primeFactors(n).size();
    }

    static long numPF(long n) {
        Map<Long, Integer> map = primeFactors(n);
        long ans = 0;
        for (Long key : map.keySet()) {
            ans += map.get(key);
        }
        return ans;
    }

    /**
     * Count the number of positive integers strictly lower then N that are
     * relatively prime to N
     */
    static long EulerPhi(long n) {
        long ans = n;
        long index = 0;
        long PF = primes.get((int) index);
        while (PF * PF <= n) {
            if (n % PF == 0) {
                ans -= ans / PF;
            }
            while (n % PF == 0) {
                n /= PF;
            }
            PF = primes.get((int) ++index);
        }
        if (n != 1) {
            ans -= ans / n;
        }
        return ans;
    }

    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out);
        sieve();
        int n = 60;
        Map<Long, Integer> map1 = primeFactors(n);
        out.println(map1);
        out.println(numPF(n));
        out.println(numDiffPF(n));
        out.println(sumPF(n));
        out.println(numDiv(n));
        out.println(sumDiv(n));
        out.println(EulerPhi(n));
        out.close();
    }
}
