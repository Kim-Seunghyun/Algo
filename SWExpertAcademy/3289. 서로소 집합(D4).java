import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class M3289 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[] arr = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				arr[i] = i;
			}
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int operator = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				if (operator == 0)
					add(arr, x, y);
				else {
					if (findRepresent(arr, x) == findRepresent(arr, y))
						sb.append(1); //대표가 같으면 같은 집단이니 1 출력
					else
						sb.append(0); //아니면 0 출력
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	private static int findRepresent(int[] arr, int x) {
		if (arr[x] == x)  //지금 인덱스의 대표자가 본인이라면
			return x; //본인 리턴
		return arr[x] = findRepresent(arr, arr[x]); //아니면 대표찾기
	}

	private static void add(int[] arr, int x, int y) {
		int representX = findRepresent(arr, x);
		int representY = findRepresent(arr, y); //각각의 대표자를 찾아서
		if (representX == representY) //같으면 의미없음
			return;
		arr[representX] = representY; //다르면 대표 바꾸기
	}

}
