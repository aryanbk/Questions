// repeat it
class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        int[] finalHealths = new int[n];
        Arrays.fill(finalHealths, -1);

        List<int[]> robots = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            robots.add(new int[]{positions[i], healths[i], i});
        }
        
        Collections.sort(robots, (a, b) -> a[0] - b[0]);

        Deque<int[]> left = new ArrayDeque<>();
        Deque<int[]> right = new ArrayDeque<>();

        for (int[] robot : robots) {
            if (directions.charAt(robot[2]) == 'R') {
                right.push(robot);
            } else {
                while (!right.isEmpty()) {
                    int[] rightRobot = right.peek();
                    if (rightRobot[1] > robot[1]) {
                        rightRobot[1]--;
                        robot[1] = 0;
                        break;
                    } else if (rightRobot[1] < robot[1]) {
                        rightRobot[1] = 0;
                        robot[1]--;
                        right.pop();
                    } else {
                        rightRobot[1] = 0;
                        robot[1] = 0;
                        right.pop();
                        break;
                    }
                }
                if (robot[1] > 0) {
                    left.push(robot);
                }
            }
        }

        while (!right.isEmpty()) {
            int[] robot = right.pop();
            finalHealths[robot[2]] = robot[1];
        }

        while (!left.isEmpty()) {
            int[] robot = left.pop();
            finalHealths[robot[2]] = robot[1];
        }
        
        List<Integer> healthList = new ArrayList<>();
        for (int health : finalHealths) {
            if (health > 0) {
                healthList.add(health);
            }
        }
        
        return healthList;
    }
}