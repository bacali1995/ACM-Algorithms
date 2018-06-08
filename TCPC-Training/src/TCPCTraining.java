
import java.io.*;
import java.util.*;

public class TCPCTraining {

    public static void main(String[] args) {
        FastScanner in = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        int[] tab = new int[n];
        for (int i = 0; i < tab.length; i++) {
            tab[i] = in.nextInt();
        }
        Arrays.sort(tab);
        IntArrayList list = new IntArrayList(n);
        list.add(tab[0]);
        int i = 1;
        int ans = 0;
        while (i < n) {
            if (tab[i] > tab[i - 1] + 1) {
                ans += doWork(list);
                list = new IntArrayList(n - i);
                list.add(tab[i]);
            } else if (tab[i] == tab[i - 1]) {
                list.arr[list.size - 1] += tab[i];
            } else if (tab[i] == tab[i - 1] + 1) {
                list.add(tab[i]);
            }
            i++;
        }
        i--;
        if (!(tab[i] > tab[i - 1] + 1)) {
            ans += doWork(list);
        }
        out.println(ans);
        out.close();

    }

    static int doWork(IntArrayList list) {
        if (list.size == 0) {
            return 0;
        }
        if (list.size == 1) {
            return list.arr[0];
        }
        int max = 0;
        for (int i = 0; i < list.size; i++) {
            int v = doWork(list.removeRangeAndCopy(i-1, 3))+list.arr[i];
            max = Math.max(max, v);
        }
        return max;
    }

    static class IntArrayList {

        private int[] arr;
        private int size;
        private double ratio = 2.0;

        public IntArrayList(int initSize) {
            arr = new int[initSize];
        }

        public IntArrayList() {
            arr = new int[10];
        }

        private IntArrayList(int[] newArr) {
            this.arr = newArr;
            this.size = newArr.length;
        }

        public void add(int a) {
            ensureSize(size + 1);
            arr[size++] = a;
        }

        public void removeAt(int index) {
            System.arraycopy(arr, index, arr, index + 1, size - index - 1);
        }

        public IntArrayList removeRangeAndCopy(int offset, int count) {
            if (offset < 0) {
                count += offset;
                offset = 0;
            }
            if (offset + count > size) {
                count = size - offset;
            }
            if (count < 0) {
                return new IntArrayList(arr);
            }
            int[] newArr = new int[size - count];
            System.arraycopy(arr, 0, newArr, 0, offset);
            System.arraycopy(arr, offset + count, newArr, offset, size - count - offset);
            return new IntArrayList(newArr);
        }

        private void ensureSize(int i) {
            if (i > arr.length) {
                int[] newArr = new int[(int) (arr.length * ratio)];
                System.arraycopy(arr, 0, newArr, 0, arr.length);
                this.arr = newArr;
            }
        }

        public int[] toArray() {
            return Arrays.copyOf(arr, size);
        }

    }

    static class FastScanner {

        BufferedReader br;
        StringTokenizer st;

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

    }
}
