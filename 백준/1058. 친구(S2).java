import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1058 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[][] arr = new char[N][N];
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine().toCharArray();
		}
    //입력완료
		int[] twoFriend = new int[N]; //2-친구 관리할 배열
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 'Y') //Y라면 카운트 증가
					twoFriend[i]++;
				else {  //N이라면
					for (int k = 0; k < N; k++) { //둘을 아는 새로운 친구 조사
						if (i != j && arr[j][k] == 'Y' && arr[i][k] == 'Y') {
							twoFriend[i]++; //있다면 카운트 증가
							break;
						}
					}
				}
			}
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++)
			max = Integer.max(max, twoFriend[i]); //max 갱신
		System.out.println(max);
	}

}
