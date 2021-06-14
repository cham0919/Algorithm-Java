package 백준.string_pt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 가장_긴_문자열_3033 {

	  public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        br.readLine();
	        String str = br.readLine();
	 
	        // 접미사 배열(Suffix Array)
	        int[] suffixArray = findSuffixArray(str);
//	        for (int i = 0; i < str.length(); i++)
//	            System.out.print((suffixArray[i] + 1) + " ");
//	        System.out.println();
	         
	        // LCP (Longest Common Prefix)
	        int[] lcp = findLCP(str, suffixArray);
//	        System.out.print("x ");
//	        for (int i = 0; i < lcp.length-1; i++) {
//	            System.out.print(lcp[i] + " ");
//	        }
	        int max = lcp[0];
	        for (int i = 1; i < lcp.length; i++) {
				if(lcp[i]>max) max = lcp[i];
			}
	        System.out.println(max);
	  }
	 
	    public static int[] findSuffixArray(String str) {
	        int N = str.length();
	        SuffixT[] sa = new SuffixT[N];
	 
	        // 초기 인덱스, 각 접미사의 첫 글자에 맞는 사전순에 맞는 rank 지정
	        for (int i = 0; i < N; i++) {
	            // a:0, b:1, c:2, ..., z:25 
	            int rank = str.charAt(i) - 'a';
	            sa[i] = new SuffixT(i, rank);
	        }
	         
	        // 접미사 앞에서 두번째 글자로 nextRank 계산
	        for (int i = 0; i < N-1; i++) {
	            // 현재 접미사의 두번째 글자과 다음 접미사의 두번째 글자와 동일.
	            sa[i].nextRank = sa[i+1].rank;
	        }
	        sa[N-1].nextRank = -1;
	         
	             
	        // 첫글자와 두번째 글자에 따른 정렬
	        // 1차적으로 rank기준으로 정렬
	        // (rank값이 동일시) 2차적으로 rankNext 기준으로 정렬 
	        Arrays.sort(sa); 
	 
	         
	        int[] temp = new int[N];
	        // logN만큼 작업 반복(4, 8, 16 ...)
	        for (int length = 4; length < 2 * N; length <<= 1) {
	            // rank값 갱신 (초기값 세팅)
	            int rank = 0, prev = sa[0].rank;
	            sa[0].rank = rank;
	            temp[sa[0].index] = 0;
	             
	            // 두번째 원소부터 rank값 갱신
	            for (int i = 1; i < N; i++) {
	                // 앞선 접미사와 (rank, nextRank) 동일 여부 확인
	                if (sa[i].rank == prev && sa[i].nextRank == sa[i - 1].nextRank) {
	                    prev = sa[i].rank;
	                    sa[i].rank = rank;
	                } 
	                else { // 다른 경우 (rank + 1) 할당
	                    prev = sa[i].rank;
	                    sa[i].rank = ++rank;
	                }
	                temp[sa[i].index] = i;
	            }
	 
	            // nextRank 갱신
	            for (int i = 0; i < N; i++) {
	                int nextIdx = sa[i].index + (length / 2);
	                if(nextIdx >= N) {
	                    sa[i].nextRank = -1;
	                    continue;
	                }
	                sa[i].nextRank = sa[temp[nextIdx]].rank;
	            }
	            // 갱신된 (rank, nextRank)기준으로 접미사 배열 재정렬
	            Arrays.sort(sa);
	        }
	 
	        // 접미사 배열 반환
	        int[] suffixArray = new int[N];
	        for(int i=0; i<N; i++) {
	            suffixArray[i] = sa[i].index;
	        }
	        return suffixArray;
	    }
	     
	    private static int[] findLCP(String str, int[] suffixArray) {
	        int N = suffixArray.length;
	        int[] lcp = new int[N];
	        int[] invSuff = new int[N];
	         
	        // invSuff[]에는 접미사 배열 순서 할당
	        // ex) suffixArr[0] = 5 > invSuff[5] = 0 (역함수 관계)
	        for (int i=0; i < N; i++) {
	            invSuff[suffixArray[i]] = i;
	        }
	         
	        int k = 0; // LCP 길이 초기화 
	        for (int i=0; i<N; i++) {
	            if (invSuff[i] == N-1){ 
	                k = 0; 
	                continue; 
	            } 
	       
	            int j = suffixArray[invSuff[i]+1]; 
	       
	            // 일치 여부 검사
	            while (i+k<N && j+k<N) {
	                if(str.charAt(i+k) != str.charAt(j+k)) {
	                    break;
	                }
	                k++;
	            }
	       
	            lcp[invSuff[i]] = k;  
	 
	            if (k>0) {
	                k--;
	            }
	        } 
	        return lcp; 
	    }
	}
	 
	class SuffixT implements Comparable<SuffixT> {
	    int index; // 초기 인덱스
	    int rank, nextRank;
	 
	    public SuffixT(int index, int rank) {
	        this.index = index;
	        this.rank = rank;
	    }
	 
	    public int compareTo(SuffixT target) {
	        // 같은 경우:0, 작은 경우: -1, 큰 경우: 1
	        if (this.rank != target.rank)
	            return Integer.compare(this.rank, target.rank);
	        // rank가 동일하면 nextRank로 비교
	        return Integer.compare(this.nextRank, target.nextRank);
	    }
	}
