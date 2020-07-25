package algorithm;

import java.io.*;
import java.util.*;

public class BOJ_2248_������ã�� {
	static int dp[][];
	static String answer = "";
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		long I = Long.parseLong(st.nextToken());
		dp = new int[N+1][L+1];
		for(int i=0; i<=N; i++) {
			dp[i][0] = 1;
		}//�� �ڸ����� 1�� �ϳ��� ���°��� 1����.
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=L; j++) {
				dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
				//�� ���ڸ��� 1�� �ִ°�� ==> �ڸ��� �ϳ� �ٰ� ������ �ϳ� �پ��� ���� ����.	
				//�� ���ڸ��� 0�� �ִ°�� ==> �ڸ��� �ϳ� ������ ������ �Ȱ��� ���� ����.
			}
		}
		start(N,L,I);
		System.out.println(answer);
	}//end main.
	public static void start(int n, int l, long i) {
		if(n==0)return;
		int temp = 0;
		for(int j=0; j<=l; j++) {
			temp += dp[n-1][j];
		}
		if(temp < i) { //temp�� i���� �������� �տ� 0�������� ���ü��ִ� ��� ����� ���� �� ������ �ȵȰŴϱ� �տ� 1�ִ´�.
			answer += '1';
			start(n-1,l-1,i-temp);
		}
		else { //�� �ݴ�.
			answer += '0';
			start(n-1,l,i);
		}
	}//end start.
}//end class.
