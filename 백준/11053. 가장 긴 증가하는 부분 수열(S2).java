import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11053 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		int max = 0;
		int[] score = new int[N];
		for (int i = 0; i < N; i++) {
			score[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					score[i] = Integer.max(score[i], score[j] + 1);
				}
			}
			max = max > score[i] ? max : score[i];
		}
		System.out.println(max);
	}

}
