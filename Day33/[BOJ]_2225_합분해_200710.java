package algorithm;

import java.io.*;
import java.util.StringTokenizer;


public class BOJ_2225_�պ��� {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] dp = new int[K+1][N+1];
		for(int i=0;i<=N;i++) {
			dp[1][i] = 1; //1���� �̿��ؼ� �� ���� ����� ��� ��, �ڱ� �ڽ��� ������ ���ϱ� 1�� �����Ѱ�� �־���� ����.
		}
		for(int i=2; i<=K; i++) {
			for(int j=0; j<=N; j++) {
				for(int k=0; k<=j ; k++) {
					dp[i][j] = (dp[i][j] + dp[i-1][j-k])%1000000000; 
					//i���� j�� ����°��� j���� ���� k �ϳ��� ���� i-1���� j-k�� ����� ������ ��.
				}
			}
		}
		System.out.println(dp[K][N]);
	}//end main.
}//end class.
