import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
 
public class Solution {
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Stack<int[]> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int direction[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; //상하좌우
        for (int i = 1; i <= tc; i++) {
            sb.append("#").append(i).append(" ");
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int k = 0; k < N; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            // 입력 완료
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    if (stack.isEmpty()) //스택이 비어있다면 탐색결과 저장 (갈수있는횟수, 현재인덱스의 값)
                        stack.push(new int[] { reculFind(direction, arr, N, y, x, 1), arr[y][x] });
                    else {
                        int[] tmp = new int[] { reculFind(direction, arr, N, y, x, 1), arr[y][x] };
                        if (stack.peek()[0] < tmp[0]) { //기존값보다 현재 더 많이 갈 수 있다면
                            stack.push(tmp); //스택에 넣기
                        } else if (stack.peek()[0] == tmp[0] && stack.peek()[1] > tmp[1]) { //기존값이랑 같은데 현재인덱스의 값이 더 작다면
                            stack.push(tmp); //스택에 넣기
                        }
                    }
                }
            }
            sb.append(stack.peek()[1]).append(" ").append(stack.peek()[0]).append("\n");
            stack.clear();
        }
        System.out.println(sb.toString());
    }
 
    private static int reculFind(int[][] direction, int[][] arr, int N, int y, int x, int cnt) {
        for (int i = 0; i < 4; i++) { //4방향 탐색
            int nextX = x + direction[i][1];
            int nextY = y + direction[i][0];
            if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) {
                continue; //맵 밖으로 나가는 방향이면 다음방향 탐색하러감
            }
            if (arr[y][x] + 1 == arr[nextY][nextX]) { //다음으로 갈 수 있으면 거기서 한 번더 실행
                return reculFind(direction, arr, N, nextY, nextX, cnt + 1);
            }
        }
        return cnt; //아무곳도 못가면 1 리턴
    }
 
}
