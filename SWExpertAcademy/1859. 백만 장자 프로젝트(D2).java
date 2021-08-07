import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= T; i++) {
			sb.append("#").append(i).append(" ");
			long res = 0;
			int N = Integer.parseInt(br.readLine());
			String[] arr = br.readLine().split(" ");
			//입력완료
			int size = arr.length - 2;
			int prev = Integer.parseInt(arr[size + 1]);
			while (size >= 0) {
				int next = Integer.parseInt(arr[size]);
				if (prev > next)	//다음가격이 이전보다 크다면 수익을 저장
					res = res + (prev - next);
				else {	//다음가격이 이전보다 작거나 같다면 이전값을 다음값으로 옮겨옴
					prev = next;
				}
				size--;
			}

			sb.append(res).append("\n");
		}
		System.out.println(sb.toString());
	}
}
