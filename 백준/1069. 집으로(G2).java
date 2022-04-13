import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1069_G2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		double distance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
		double res = 0;
		// X,Y 에서 0,0으로
		// 1초에 1만큼 움직이기
		// T초에 D만큼 점프하기
		// 원점과 x,y를 지나는 직선

		// 남은 거리가 D보다 클 때 D/T > 1 이라면 T초만큼 D 이동
		// '' D/T <= 1 이라면 n초만큼 n 이동
		// 남은 거리가 D보다 작을 때 D/T > 1 이라면 T + D-dis , dis 중 작은 것 선택
		// 남은 거리가 D 보다 클 떄 T 2번으로 골인 하는 경우도 생각
		while (distance > 0) {
			if (distance > D) {
				if ((double) D / (double) T > 1) {
					if (distance - 2 * D <= 0) {
						double tmp = 2 * T < T + distance - D ? 2 * T : T + distance - D;
						res += tmp;
						distance = 0;
						continue;
					}
					distance -= D;
					res += T;
				} else {
					distance -= D;
					res += D;
				}
			} else {
				double tmp = T + D - distance;
				if ((double) D / (double) T > 1) {
					if (tmp > distance)
						tmp = distance;
					if (tmp > 2 * T)
						tmp = 2 * T;
				} else
					tmp = distance;
				res += tmp;
				distance = 0;
			}
		}
		System.out.println(res);
	}

}
