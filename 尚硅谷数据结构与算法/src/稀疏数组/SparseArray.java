package 稀疏数组;

public class SparseArray {
    public static void main(String[] args) {
        //创建原始数组。0表示无子，1表示黑子，2表示蓝子
        int r = 7;
        int c = 7;
        int chessArr1[][]=new int[r][c];
        chessArr1[1][2]=1;
        chessArr1[2][3]=2;
        //chessArr1[4][5]=9;
        System.out.println("原始二维数组");
        SparseArray sa = new SparseArray();
        sa.printArr(chessArr1);
        //一、将二维数组转稀疏数组的思路
        //1.先遍历二维数组，看有多少个非0数据
        int sum = 0;
        for (int i=0;i<r;i++){
            for (int j=0;j<c;j++){
                if (chessArr1[i][j]!=0){
                    sum++;
                }
            }
        }
        System.out.println("sum="+sum);
        //2.创建稀疏数组
        int[][] sparseArr = new int[sum+1][3];
        sparseArr[0][0]=r;
        sparseArr[0][1]=c;
        sparseArr[0][2]=sum;
        int count = 0;
        for (int i = 0;i<r;i++){
            for (int j =0;j<c;j++){
                if (chessArr1[i][j]!=0){
                    count++;
                    sparseArr[count][0]=i;
                    sparseArr[count][1]=j;
                    sparseArr[count][2]=chessArr1[i][j];
                }
            }
        }
        //3.输出该稀疏数组
        sa.printArr(sparseArr);


        //二、将稀疏数组还原为二维数组
        //1.读取稀疏数组第一行数据,并依此创建二维数组
        int rr = sparseArr[0][0];
        int cc = sparseArr[0][1];
        int row = 0;
        int col = 0;
        int val = 0;
        int[][] chess = new int[rr][cc];
        for (int i = 1;i<sparseArr.length;i++){
            row = sparseArr[i][0];
            col = sparseArr[i][1];
            val = sparseArr[i][2];
            chess[row][col]=val;
        }
        sa.printArr(chess);
    }

    void printArr(int[][] arr){
        for (int[] row:arr){
            for (int data:row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
    }
}
