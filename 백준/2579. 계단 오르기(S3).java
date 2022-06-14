import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2579 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int[][] score = new int[N + 1][2];
		score[1][0] = score[1][1] = arr[0];
		for (int i = 2; i <= N; i++) {
			score[i][0] = score[i - 1][1] + arr[i - 1];
			score[i][1] = Integer.max(score[i - 2][0], score[i - 2][1]) + arr[i - 1];
		}
		System.out.println(Integer.max(score[N][0], score[N][1]));
	}

}
