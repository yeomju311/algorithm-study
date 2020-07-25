package algorithm;

import java.io.*;
import java.util.*;

public class BOJ_1976_���డ�� {
	static int[] parent;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		parent = new int[N];
		for(int i=0; i<N; i++) {
			parent[i] = i;
		}//�ڱ� �θ� �ϴ� �ڱ� �ڽ����� ����.
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    union(i, j);
                }
            }
        }//Union.
		st = new StringTokenizer(br.readLine());
		int left = Integer.parseInt(st.nextToken())-1;
		for(int i=0; i<M-1; i++) {
			int right = Integer.parseInt(st.nextToken())-1;
			if(find(left)!=find(right)) {
				System.out.println("NO");
				return ;
			}
			left = right;
		}
		System.out.println("YES");
	}//end main.
	public static int find(int n) {
		if (parent[n] == n) return n;
	    parent[n] = find(parent[n]);
	    return parent[n];
	}
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a!=b) parent[a] = b; //�������� �����ش�.
	}
}//end class.
