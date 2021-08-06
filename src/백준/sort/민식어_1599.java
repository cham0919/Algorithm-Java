package 백준.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class 민식어_1599 {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int i, n = Integer.parseInt(in.readLine());

        StringBuilder res = new StringBuilder();
        Minsik m[] = new Minsik[n];

        for(i=0;i<n;i++) m[i] = new Minsik(in.readLine());
        Arrays.sort(m, (a, b) -> a.compareTo(b.str));

        for(i=0;i<n;i++) res.append(m[i].str+"\n");
        out.write(res.toString());
        out.close();
        in.close();
    }

    // 민식 클래스 구현
    static class Minsik implements Comparable<String>{

        String str;

        // 민식이 언어 인덱스
        enum Alphabet{
            a(0), b(1), k(2), d(3), e(4), g(5), h(6), i(7), l(8), m(9),
            n(10), ng(11), o(12), p(13), r(14), s(15), t(16), u(17), w(18), y(19);

            Alphabet(int num){ codeNum = num; }

            int codeNum;

            public int getCodeNum(){ return codeNum; }
        }

        public Minsik(String str){ this.str = str; }

        // 단어를 민식이 언어 배열로 변환
        private static String[] convert(String str){

            int i, k = 0, n = str.length();

            String ng = "ng", tmp;

            String init[] = new String[n];

            for(i = 0; i < n; i++){
                // 기본적으로 두개씩 자르기
                tmp = str.substring(i, i==n-1?i+1:i+2);

                // ng면 ng 더하기, 아니면 앞자리만 더하기
                if (tmp.equals(ng)) {
                    init[k++] = ng;
                    i++;
                } else {
                    init[k++] = String.valueOf(tmp.charAt(0));
                }
            }

            // null을 감안해 k만큼 잘라 return
            return Arrays.copyOf(init, k);
        }
        public int compareTo(String anotherString) {
            String []v1 = convert(str), v2 = convert(anotherString);
            int k = 0, len1 = v1.length, len2 = v2.length, lim = Math.min(len1, len2);

            // 작은 길이 만큼 반복
            while (k < lim) {
                String s1 = v1[k], s2 = v2[k];
                if (!s1.equals(s2)) {
                    return Alphabet.valueOf(s1).getCodeNum() - Alphabet.valueOf(s2).getCodeNum();
                }
                k++;
            }
            return len1 - len2;
        }
    }

}


