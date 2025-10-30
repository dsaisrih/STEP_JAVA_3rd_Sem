import java.util.*;

public class StringPerf{

    static long[] testConcat(int n) {
        long start = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < n; i++) s += "abc";
        long end = System.currentTimeMillis();
        return new long[]{end - start, s.length()};
    }

    static long[] testBuilder(int n) {
        long start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) sb.append("abc");
        long end = System.currentTimeMillis();
        return new long[]{end - start, sb.length()};
    }

    static long[] testBuffer(int n) {
        long start = System.currentTimeMillis();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) sb.append("abc");
        long end = System.currentTimeMillis();
        return new long[]{end - start, sb.length()};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long[] concat = testConcat(n);
        long[] builder = testBuilder(n);
        long[] buffer = testBuffer(n);

        System.out.println("Method        Time(ms)  Length");
        System.out.printf("String (+)    %8d  %d\n", concat[0], concat[1]);
        System.out.printf("StringBuilder %8d  %d\n", builder[0], builder[1]);
        System.out.printf("StringBuffer  %8d  %d\n", buffer[0], buffer[1]);
    }
}