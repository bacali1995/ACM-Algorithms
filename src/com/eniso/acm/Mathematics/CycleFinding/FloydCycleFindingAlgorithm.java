package com.eniso.acm.Mathematics.CycleFinding;

import java.io.PrintWriter;

public class FloydCycleFindingAlgorithm {

    private static int f(int x) {
        return (7 * x + 5) % 12;
    }

    static class pair {

        int mu;
        int lambda;

        public pair(int first, int second) {
            this.mu = first;
            this.lambda = second;
        }

        @Override
        public String toString() {
            return "pair{" + "mu=" + mu + ", lambda=" + lambda + '}';
        }

    }

    public static pair floydCycleFinding(int x0) {
        int tortoise = f(x0);
        int hare = f(f(x0));
        while (tortoise != hare) {
            tortoise = f(tortoise);
            hare = f(f(hare));
        }
        int mu = 0;
        hare = x0;
        while (tortoise != hare) {
            tortoise = f(tortoise);
            hare = f(hare);
            mu++;
        }
        int lambda = 1;
        hare = f(tortoise);
        while (tortoise != hare) {
            hare = f(hare);
            lambda++;
        }
        return new pair(mu, lambda);
    }

    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out);
        out.println(floydCycleFinding(4));
        out.close();
    }

}
