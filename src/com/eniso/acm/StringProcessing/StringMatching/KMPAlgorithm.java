package com.eniso.acm.StringProcessing.StringMatching;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class KMPAlgorithm {

    private static int[] backTable = new int[1000000];

    public static void kmpPreprocess(char[] p, int m) {
        int i = 0, j = -1;
        backTable[0] = -1;
        while (i < m) {
            while (j >= 0 && p[i] != p[j]) {
                j = backTable[j];
            }
            i++;
            j++;
            backTable[i] = j;
        }
    }

    public static List<Integer> kmpSearch(char[] t, int n, char[] p, int m) { // this is similar as kmpPreprocess(), but on string T
        List<Integer> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < n) {
            while (j >= 0 && t[i] != p[j]) {
                j = backTable[j];
            }
            i++;
            j++;
            if (j == m) {
                res.add(i - j);
                j = backTable[j];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out);
        String ch = "Nasreddine Bac Ali Bac Ali";
        String p = "Bac Ali";
        kmpPreprocess(p.toCharArray(), p.length());
        out.println(kmpSearch(ch.toCharArray(), ch.length(), p.toCharArray(), p.length()));
        out.close();
    }
    
}
