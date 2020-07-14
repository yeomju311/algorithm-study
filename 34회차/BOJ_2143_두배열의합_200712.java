package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_2143_�ι迭����_200712 {
	static int T;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		int[] A = new int[n];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < A.length; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		int m =  Integer.parseInt(br.readLine());
		int[] B = new int[m];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < B.length; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		ArrayList<Integer> AsublistSum = sublistSum(A);
		ArrayList<Integer> BsublistSum = sublistSum(B);
		
		Collections.sort(AsublistSum);
		Collections.sort(BsublistSum);
		
		long result = 0;
		int aSize = AsublistSum.size();
		int bSize = BsublistSum.size();
		int aPointer = 0, bPointer = bSize-1;
		// �ΰ��� �����Ͱ� ���� ������ ������ ����
		while(aPointer < aSize && bPointer >= 0) {
			int aVal = AsublistSum.get(aPointer);
			int bVal = BsublistSum.get(bPointer);
			// ���� T�� ��
			if(aVal + bVal == T) {
				// a���� �ߺ��� �Ͱ� b���� �ߺ��� ���� ������ ã�� ���ؼ� result�� ���Ѵ�
				long aCount = 1;
				long bCount = 1;
				while(aPointer + 1 < aSize && 
						AsublistSum.get(aPointer + 1) == aVal) {
					aPointer++;
					aCount++;
				}
				while(bPointer - 1 >= 0 && 
						BsublistSum.get(bPointer - 1) == bVal) {
					bPointer--;
					bCount++;
				}
				result += aCount * bCount;
				aPointer++;
				bPointer--;
			}
			// ���� T���� ���� ��
			else if(aVal + bVal < T) {
				aPointer++;
			}
			// ���� T���� Ŭ ��
			else if(aVal + bVal > T) {
				bPointer--;
			}
		}
		System.out.println(result);
	}

	// �� �迭���� �κ����� ����Ʈ�� ����
	private static ArrayList<Integer> sublistSum(int[] arr) {
		ArrayList<Integer> sublistSum = new ArrayList<>();
		
		for (int i = 0; i < arr.length; i++) {
			int tmp = 0;
			int j = i;
			for (;  j < arr.length; j++) {
				tmp += arr[j];
				sublistSum.add(tmp);
			}
		}
		
		return sublistSum;
	}
}
