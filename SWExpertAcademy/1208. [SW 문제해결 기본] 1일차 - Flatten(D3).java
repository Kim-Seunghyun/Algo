import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader((new InputStreamReader(System.in)));
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= 10; i++) {
			sb.append("#").append(i).append(" ");
			int dump = Integer.parseInt(in.readLine());
			int result = 0;
			int[] arr = new int[100];
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < 100; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			//입력완료
			reDump(arr, dump);
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			for (int j = 0; j < arr.length; j++) {
				if (arr[j] > max)
					max = arr[j];
				if (arr[j] < min)
					min = arr[j];
			}
			sb.append((max - min)).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void reDump(int[] arr, int dump) {
		//최대덤프횟수가 0이 되면 종료
		if (dump == 0)
			return;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int minFlag = 0;
		int maxFlag = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < min) {
				min = arr[i];
				minFlag = i;
			}
			if (arr[i] > max) {
				max = arr[i];
				maxFlag = i;
			}
		}
		//최소값은 1늘리고 최댓값은 1줄임
		arr[minFlag] = arr[minFlag] + 1;
		arr[maxFlag] = arr[maxFlag] - 1;
		reDump(arr, dump - 1);
	}
}
