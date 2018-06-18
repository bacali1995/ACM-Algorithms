package com.eniso.acm.OtherCodes;

import java.io.*;

public class FastScanner2 {

    final private int BUFFER_SIZE = 1 << 16;
    private DataInputStream din;
    private byte[] buffer;
    private String[] stringBuffer;
    private int bufferPointer, bytesRead, stringPointer;

    public FastScanner2(InputStream inputStream) {
        din = new DataInputStream(inputStream);
        buffer = new byte[BUFFER_SIZE];
        stringBuffer = new String[0];
        stringPointer = bufferPointer = bytesRead = 0;
    }

    public String next() {
        if (stringPointer == stringBuffer.length) {
            nextLine();
            stringPointer = 0;
        }
        return stringBuffer[stringPointer++];
    }

    public String nextLine() {
        byte[] buf = new byte[1 << 16];
        int cnt = 0, c;
        while ((c = read()) != -1) {
            if (c == '\n') {
                break;
            }
            buf[cnt++] = (byte) c;
        }
        String result = new String(buf, 0, cnt);
        stringBuffer = result.trim().split(" ");
        stringPointer = stringBuffer.length;
        return result;
    }

    public int nextInt() {
        int ret = 0;
        byte c = read();
        while (c <= ' ') {
            c = read();
        }
        boolean neg = (c == '-');
        if (neg) {
            c = read();
        }
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');

        if (neg) {
            return -ret;
        }
        return ret;
    }

    public long nextLong() {
        long ret = 0;
        byte c = read();
        while (c <= ' ') {
            c = read();
        }
        boolean neg = (c == '-');
        if (neg) {
            c = read();
        }
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
        if (neg) {
            return -ret;
        }
        return ret;
    }

    public double nextDouble() {
        double ret = 0, div = 1;
        byte c = read();
        while (c <= ' ') {
            c = read();
        }
        boolean neg = (c == '-');
        if (neg) {
            c = read();
        }

        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');

        if (c == '.') {
            while ((c = read()) >= '0' && c <= '9') {
                ret += (c - '0') / (div *= 10);
            }
        }

        if (neg) {
            return -ret;
        }
        return ret;
    }

    private void fillBuffer() {
        try {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (bytesRead == -1) {
            buffer[0] = -1;
        }
    }

    private byte read() {
        if (bufferPointer == bytesRead) {
            fillBuffer();
        }
        return buffer[bufferPointer++];
    }

    public void close() {
        if (din == null) {
            return;
        }
        try {
            din.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
