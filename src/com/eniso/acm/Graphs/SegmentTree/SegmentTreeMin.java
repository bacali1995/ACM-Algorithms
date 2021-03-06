package com.eniso.acm.Graphs.SegmentTree;


public class SegmentTreeMin {

    private int n;
    private int[] st;
    private int[] A;

    public SegmentTreeMin(int[] A) {
        this.A = A;
        n = A.length;
        st = new int[4 * n];
        build(1, 0, n - 1);
    }

    public int rmq(int i, int j) {
        return rmq(1, 0, n - 1, i, j);
    }

    private int left(int p) {
        return p << 1;
    }

    private int right(int p) {
        return (p << 1) + 1;
    }

    private void build(int p, int L, int R) {
        if (L == R) {
            st[p] = L;
        } else {
            build(left(p), L, (L + R) / 2);
            build(right(p), (L + R) / 2 + 1, R);
            int p1 = st[left(p)];
            int p2 = st[right(p)];
            st[p] = (A[p1] <= A[p2]) ? p1 : p2;
        }
    }

    private int rmq(int p, int L, int R, int i, int j) {
        if (i > R || j < L) {
            return -1;
        }
        if (L >= i && R <= j) {
            return st[p];
        }
        int p1 = rmq(left(p), L, (L + R) / 2, i, j);
        int p2 = rmq(right(p), (L + R) / 2 + 1, R, i, j);
        if (p1 == -1) {
            return p2;
        }
        if (p2 == -1) {
            return p1;
        }
        return (A[p1] <= A[p2]) ? p1 : p2;
    }
}
