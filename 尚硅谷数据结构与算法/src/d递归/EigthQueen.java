package d递归;
//在8x8的格子内放8个皇后，任两个不能处于同一行、同一列或同一斜线上
//0表示没有放，1表示放了皇后

public class EigthQueen {
    //定义一个max表示共有多少个皇后
    public final static int MAX = 8;
    //定义一个数组arr,保存皇后放置位置的结果，比如arr[0] = {0,4,7,5,2,6,1,3}
    public static int[][] arr = new int[MAX][MAX];

    public static void main(String[] args) {
        init();
        show();

    }

    //初始化棋盘
    public static void init() {
        for (int i = 0; i < MAX; i++) {
            for (int j = 0; j < MAX; j++) {
                arr[i][j] = 0;
            }
        }
    }

    //写一个方法，将皇后摆放的位置打印出来
    public static void show() {
        for (int i = 0; i < MAX; i++) {
            for (int j = 0; j < MAX; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    //判断当放置第N个皇后时，与前面摆好的皇后是否冲突
    private boolean judge(int n) {//n表示放置第n个皇后
        for (int i = 0; i < n; i++) {

        }
        return false;
    }
}
