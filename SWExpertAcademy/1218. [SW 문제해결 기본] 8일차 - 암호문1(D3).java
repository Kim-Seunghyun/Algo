import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class M1316 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = 10;
		for (int i = 1; i <= tc; i++) {
			int[] arr = new int[10];
			int cnt = 0;
			br.readLine();
			StringTokenizer st = new StringTokenizer(br.readLine());
			while (true) {
				if (cnt < tc) {
					arr[cnt++] = Integer.parseInt(st.nextToken());
				}
				if (cnt == tc)
					break;
      }//초기 입력
			sb.append("#").append(i).append(" ");
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				st.nextToken();
				int num = Integer.parseInt(st.nextToken());
				int size = Integer.parseInt(st.nextToken());
				int[] tmp = new int[size];
				int k = 0;
				while (k < size) {
					tmp[k++] = Integer.parseInt(st.nextToken());
				}//I는 버리고 정수만 입력
				insert(arr, tmp, num);
			}
			for (int j = 0; j < 10; j++) {
				sb.append(arr[j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	static void insert(int[] arr, int[] tmp, int num) {
		if (num > 9)  //입력 위치가 9번보다 크면 실행안함
			return;
		int[] clone = new int[9];
		for (int i = 0; i < 9; i++) {
			clone[i] = arr[i];
		} //기존배열값 복사
		int i, j;
		for (i = 0, j = num; i < tmp.length; i++, j++) {
			if (j == 10)
				break;
			arr[j] = tmp[i];
		} //입력위치에 덮어씌우고
		i = num;
		while (j < 10) {  //기존값들 뒤로 
			arr[j++] = clone[i++];
		} 
	}
}
