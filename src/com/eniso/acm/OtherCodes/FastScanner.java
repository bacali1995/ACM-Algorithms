package com.eniso.acm.OtherCodes;

import java.io.*;
import java.util.StringTokenizer;

public class FastScanner {

    private BufferedReader br;
    private StringTokenizer st;

    public FastScanner(InputStream inputStream) {
        br = new BufferedReader(new InputStreamReader(inputStream));
    }

    public String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }

    public String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    public int[] nextIntArray(int n) {
        int[] tab = new int[n];
        for (int i = 0; i < n; i++) {
            tab[i] = nextInt();
        }
        return tab;
    }

    long[] nextLongArray(int n) {
        long[] tab = new long[n];
        for (int i = 0; i < n; i++) {
            tab[i] = nextLong();
        }
        return tab;
    }

}
