package d递归;

public class MiGong {
    public static void main(String[] args) {
        //先创建一个二维数组，模拟迷宫地图
        int[][] map = new int[8][7];
        //使用1表示墙，先把上下置为1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int j = 0; j < 8; j++) {
            map[j][0] = 1;
            map[j][6] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;
        System.out.println("输出地图：");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        //使用递归找路
        setWay(map, 1, 1);//map是数组，是个引用，无论调用多少次，都是修改同一张地图
        //输了新地图
        System.out.println("小球走过的地图：");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * @param map 地图
     * @param i   从哪个位置开始出发
     * @param j   起（1，1）-->末（6，5）
     * @return 遇通路返回true，否则false
     * 当map[i][j]为0，表示没有走过，2表示通路可以走，3表示已走过但不通
     * 定义策略：先哪个方向，再走哪个方向，如下->右->上->左
     */
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            return true;
        } else {
            if (map[i][j] == 0) {
                map[i][j] = 2;
                if (setWay(map, i - 1, j)) {
                    return true;
                } else if (setWay(map, i, j + 1)) {
                    return true;
                } else if (setWay(map, i + 1, j)) {
                    return true;
                } else if (setWay(map, i, j - 1)) {
                    return true;
                } else {
                    map[i][j] = 3;
                    return false;
                }
            } else {
                return false;
            }
        }
    }


}
