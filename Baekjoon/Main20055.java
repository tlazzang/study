import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main20055 {

    public static int[] beltDurability;
    public static boolean[] isExistRobot;
    public static List<Robot> robots;
    public static int N, K;
    public static int cnt;
    public static int answer = 1;

    public static class Robot {
        int position;

        public Robot(int position) {
            this.position = position;
        }
    }

    public static void rotateBelt() {
        int last = beltDurability[beltDurability.length - 1];
        boolean lastHasRobot = isExistRobot[isExistRobot.length - 1];
        for (int i = beltDurability.length - 1; i >= 1; i--) {
            beltDurability[i] = beltDurability[i - 1];
            isExistRobot[i] = isExistRobot[i - 1];
        }
        beltDurability[0] = last;
        isExistRobot[0] = lastHasRobot;

        Iterator<Robot> it = robots.iterator();
        while (it.hasNext()) {
            Robot r = it.next();
            r.position = (r.position + 1) % (2 * N);
            if (r.position == N - 1) {
                it.remove();
            }
        }
        isExistRobot[N - 1] = false;
    }

    public static void moveRobots() {
        Iterator<Robot> it = robots.iterator();
        while (it.hasNext()) {
            Robot r = it.next();
            int next = (r.position + 1) % (2 * N);
            if (!isExistRobot[next] && beltDurability[next] > 0) {
                isExistRobot[r.position] = false;
                isExistRobot[next] = true;
                r.position = next;
                if (--beltDurability[next] == 0) {
                    cnt++;
                }
            }
            if (r.position == N - 1) {
                it.remove();
            }
        }
        isExistRobot[N - 1] = false;
    }

    public static void putRobotAtStartPosition() {
        if (!isExistRobot[0] && beltDurability[0] > 0) {
            robots.add(new Robot(0));
            if (--beltDurability[0] == 0)
                cnt++;
            isExistRobot[0] = true;
        }
    }

    public static int solution() {
        while (true) {
            rotateBelt();
            moveRobots();
            putRobotAtStartPosition();
            if (cnt >= K)
                return answer;
            answer++;
        }
    }

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.valueOf(input[0]);
        K = Integer.valueOf(input[1]);
        beltDurability = new int[2 * N];
        isExistRobot = new boolean[2 * N];
        robots = new ArrayList<>();

        input = br.readLine().split(" ");

        for (int i = 0; i < 2 * N; i++) {
            beltDurability[i] = Integer.valueOf(input[i]);
        }

        System.out.println(solution());
    }

}
