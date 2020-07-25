package algorithm;

import java.io.*;
import java.util.*;

public class BOJ_7453_����0�γ����� {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long[] list1 = new long[N];
		long[] list2 = new long[N];
		long[] list3 = new long[N];
		long[] list4 = new long[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			list1[i] = Long.parseLong(st.nextToken());
			list2[i] = Long.parseLong(st.nextToken());
			list3[i] = Long.parseLong(st.nextToken());
			list4[i] = Long.parseLong(st.nextToken());
		}//�Է��� �ϴ� �� �޾�.
		//4���� �迭�� 2���� �����.
		long[] list_a = new long[N*N];
		long[] list_b = new long[N*N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				list_a[i*N + j] = list1[i] + list2[j];
				list_b[i*N + j] = list3[i] + list4[j];
			}
		}
		Arrays.sort(list_a);
		Arrays.sort(list_b);
		long flag_a = 0L;
		long flag_b = N*N-1;
		long answer = 0L;
		while(flag_a<N*N && flag_b>=0) {
			long temp = list_a[(int)flag_a] + list_b[(int)flag_b];
			if(temp == 0) {
				long cnt_a  = 0 ;
				while(true) {
					if(flag_a + cnt_a >= N*N) break;
					if(list_a[(int)flag_a+(int)cnt_a] != list_a[(int)flag_a]) break;
					cnt_a ++;
				}
				long cnt_b  = 0 ;
				while(true) {
					if(flag_b-cnt_b < 0) break;
					if(list_b[(int)flag_b-(int)cnt_b] != list_b[(int)flag_b]) break;
					cnt_b ++;
				}
				answer += cnt_a * cnt_b;
				flag_a += cnt_a;
				flag_b -= cnt_b;
			}
			else if(temp > 0) flag_b--;//flag_b �����ֱ�.
			else flag_a++; //flag_a �÷��ֱ�.
		}//�̳� ����.
		System.out.println(answer);
	}//end Main.
}//end Class.
