package algorithm;

import java.io.*;
import java.util.*;

public class BOJ_9935_���ڿ����� {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();
		String str2 = br.readLine();
		char last = str2.charAt(str2.length()-1);
		int top = -1;
		char[] stack = new char[str1.length()];
		for(int i=0; i<str1.length(); i++) {
			char now = str1.charAt(i);
			if(now == last && top >= str2.length()-2) {
				boolean can_erase = true;
				for(int j=0; j<str2.length()-1; j++) {
					if(stack[top-j] != str2.charAt(str2.length()-(2+j))) {
						can_erase = false;
						break;
					}
				}
				if(can_erase) top -= str2.length()-1; //����� �ִ°�� top��ġ�� �ٲ��ش�.
				else stack[++top] = now;
			}//���ϴ� ������ �ǳ� ���ڰ� ������� �񱳽���.
			else stack[++top] = now;
		}//end for.
		if(top == -1) System.out.println("FRULA");
		else {
			for(int i=0; i<=top; i++) {
				System.out.print(stack[i]);
			}
		}
	}//end main.
}//end class.
