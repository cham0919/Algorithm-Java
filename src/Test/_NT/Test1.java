package Test._NT;


import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Test1 {

    public static void main(String[] args) throws UnsupportedEncodingException {
        Test1 test = new Test1();
        List<String> aTestCases = getATestCases();
        List<String> bTestCases = getbTestCases();
        List<Integer> results = getResultTestCases();

        for (int i = 0; i < aTestCases.size(); i++) {
            int result = test.solution(aTestCases.get(i), bTestCases.get(i));

            if (result ==  results.get(i)) {
                System.out.printf("성공 : %s \n", result);
            } else {
                System.out.printf("실패 : %s , 정답 : %s \n", result, results.get(i));
            }
        }
    }

    private int solution(String a, String b) {
        System.out.println(a);
        BigInteger num = new BigInteger(a);
        BigInteger cnt = new BigInteger(b).subtract(BigInteger.ONE);
        int i = 1;
        while (!cnt.equals(BigInteger.ZERO)) {
            String tmpNum = num.shiftLeft(1).toString();
            if (tmpNum.length() >= 5) {
                tmpNum = tmpNum.substring(tmpNum.length()-5);
            }
            num = new BigInteger(tmpNum);
            cnt = cnt.subtract(BigInteger.ONE);
        }

        return num.intValue();
    }

    public static byte[] shiftLeft(byte[] data, int len) {
        int word_size = (len / 8) + 1;
        int shift = len % 8;
        byte carry_mask = (byte) ((1 << shift) - 1);
        int offset = word_size - 1;
        for (int i = 0; i < data.length; i++) {
            int src_index = i+offset;
            if (src_index >= data.length) {
                data[i] = 0;
            } else {
                byte src = data[src_index];
                byte dst = (byte) (src << shift);
                if (src_index+1 < data.length) {
                    dst |= data[src_index+1] >>> (8-shift) & carry_mask;
                }
                data[i] = dst;
            }
        }
        return data;
    }


    //    ===================================================TEST CASE===========================================================

    public static List<Integer> getResultTestCases(){
        List<Integer> results = new ArrayList<>();
        results.add(8864);
        results.add(38549);
        results.add(0);

        return results;
    }



    public static List<String> getATestCases(){
        String a1 = "2";
        String a2 = "123456789";
//        String a3 = "10000000000000";

        List<String> aList = new ArrayList<>();
        aList.add(a1);
        aList.add(a2);
//        aList.add(a3);

        return aList;
    }

    public static List<String> getbTestCases(){
        String b1 = "26";
        String b2 = "12345";
        String b3 = "10000000000000";

        List<String> bList = new ArrayList<>();
        bList.add(b1);
        bList.add(b2);
//        bList.add(b3);

        return bList;
    }
}
