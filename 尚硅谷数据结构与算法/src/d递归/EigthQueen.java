package d递归;
//在8x8的格子内放8个皇后，任两个不能处于同一行、同一列或同一斜线上
//0表示没有放，1表示放了皇后

public class EigthQueen {
    //定义一个max表示共有多少个皇后
    static int MAX = 8;
    static int[][] map = new int[MAX][MAX];
    static int sum = 0;
    public static void main(String[] args) {
        backtrace(0);//回溯算法
        System.out.println(sum);//输出总共有多少个解

    }


    public static void backtrace(int t){
        if (t == MAX){
            sum++;
            for (int i = 0;i<MAX;i++){
                for (int j = 0;j<MAX;j++){
                    System.out.print(map[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println("===第"+sum+"种解法===");
        }else{
            for (int j = 0;j<MAX;j++){
                if (check(t,j)){
                    map[t][j]=1;
                    backtrace(t+1);
                    map[t][j]=0;
                }
            }
       }
    }
    //放置皇后，并检查与前面摆好的皇后是否冲突
    public static boolean check(int m, int n) {//检查(m,n)处是否能够放皇后
        for (int i = 0; i < n; i++) {
            if (map[m][i] == 1)//检查同行有无皇后
                return false;
        }
        for (int i = 0;i< m;i++){
            if(map[i][n] == 1)//检查同列有无皇后
                return false;
        }
        for (int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){//向左检查有无斜行
                if (map[i][j]==1 && Math.abs(m-i)==Math.abs(n-j))
                    return false;
            }
        }
        for (int i = 0;i<m;i++){
            for(int j = MAX-1;j>n;j--){//向右检查有无斜行
                if (map[i][j]==1 && Math.abs(m-i)==Math.abs(n-j))
                    return false;
            }
        }
        return true;
    }
}
/**
 * map[0][0]=1; i=0,j=0处放置一个
 * map[1][0]=1;
 **/