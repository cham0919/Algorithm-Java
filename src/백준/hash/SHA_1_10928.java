package 백준.hash;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.MessageDigest;

public class SHA_1_10928 {

	public static void main(String[] args) {
		  try {
			  
			  	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	            MessageDigest md = MessageDigest.getInstance("SHA-1"); // 이 부분을 SHA-256, MD5로만 바꿔주면 된다.
	            md.update(br.readLine().getBytes()); // "세이프123"을 SHA-1으로 변환할 예정!
	 
	            byte byteData[] = md.digest();
	 
	            StringBuffer sb = new StringBuffer(); 
	            for(int i=0; i<byteData.length; i++) {
	                sb.append(Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));
	            }
	 
	            String retVal = sb.toString();
	            System.out.println(retVal); // 결과물이 출력됨. aed19017dbb4d25a580b7f9e012e29be089bd1f3
	        } catch(Exception e){
	            e.printStackTrace(); 
	        }
	}
}
