package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class T9251 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] s1 = br.readLine().toCharArray();
		char[] s2 = br.readLine().toCharArray();
		int n1 = s1.length;
		int n2 = s2.length;
		int[][] arr = new int[n1 + 1][n2 + 1];
		int max = 0;

		for (int i = 1; i <= n1; i++) {
			for (int j = 1; j <= n2; j++) {
				if (s1[i - 1] == s2[j - 1]) {
					arr[i][j] = arr[i - 1][j - 1] + 1;
				} else {
					arr[i][j] = Integer.max(arr[i - 1][j], arr[i][j - 1]);
				}
				if (arr[i][j] > max)
					max = arr[i][j];
			}
		}
		System.out.println(max);
	}

}
