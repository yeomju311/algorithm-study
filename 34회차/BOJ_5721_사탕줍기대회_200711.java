package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_5721_�����ݱ��ȸ_200711 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		while(true) {
			st = new StringTokenizer(br.readLine()," ");
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			if(M==0 && N==0) {
				// ��������
				break;
			}
			
			int[][] box = new int[M+1][N+1];
			
			for (int i = 1; i <= M; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for (int j = 1; j <= N; j++) {
					box[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// �� �ະ �ִ�� ������ �� �ִ� ������ ������ �޸������̼ǹ迭�� ����
			int[] memo = new int[M+1];
			for (int i = 1; i <= M; i++) {
				// �� ���� �ִ밪�� dp�迭�� ���� ����
				// dp�迭�� ���� �ε������� �ֿ� ������ �ִ밪�� ������
				int[] dp = new int[N+1];
				dp[1] = box[i][1];
				for (int j = 2; j <= N; j++) {
					dp[j] = Math.max(dp[j-2] + box[i][j], dp[j-1]);
				}
				memo[i] = dp[N];
			}
			
			// ��ü �迭������ �ִ��� ���ϱ� ����
			// ���� �ε����� ���� �ִ��� ����.
			int[] dp = new int[M+1];
			dp[1] = memo[1];
			for (int i = 2; i <= M; i++) {
				dp[i] = Math.max(dp[i-2] + memo[i], dp[i-1]);
			}
			sb.append(dp[M]).append("\n");
		}
		System.out.println(sb);
	}
}
