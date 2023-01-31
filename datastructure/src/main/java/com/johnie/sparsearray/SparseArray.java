package com.johnie.sparsearray;

/**
 * 普通二维数组与稀疏数组之间的转换
 */
public class SparseArray {
    public static void main(String[] args) {
//        1. 定义一个二维数组存储棋盘上的数据 (0表示没有棋子，1表示黑子，2表示白子)
        int[][] chessArr = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        chessArr[3][4] = 2;
//        2. 输出原始的二维数组
        for (int[] row : chessArr) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
//        3. 将二维数组转化为稀疏数组
        int[][] sparseArray = getSparseArray(chessArr);

//        4. 输出稀疏数组
        System.out.println();
        System.out.println("得到的稀疏数组为：");
        for (int[] row : sparseArray) {
            System.out.printf("%d\t%d\t%d\t", row[0], row[1], row[2]);
            System.out.println();
        }
//        5. 稀疏数组转化为普通二维数组
        int[][] twoDimensionalArray = getTwoDimensionalArray(sparseArray);
//        6. 输出原始二维数组
        System.out.println();
        System.out.println("恢复后的原始数组为：");
        for (int[] row : twoDimensionalArray) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }

    /**
     * 将普通二维数组转化为稀疏数组
     *
     * @param chessArr 普通二维数组
     * @return 稀疏数组
     */
    private static int[][] getSparseArray(int[][] chessArr) {
//        1. 先遍历二维数组找到非零数据的个数
        int num = 0;
        for (int[] row : chessArr) {
            for (int data : row) {
                if (data != 0) {
                    num++;
                }
            }
        }
        int[][] sparseArray = new int[num + 1][3];
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = num;

//        2. 遍历二维数组将非零的数据存入稀疏数组 count用于记录是第几个非零数据
        int count = 0;
        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < chessArr[i].length; j++) {
                if (chessArr[i][j] != 0) {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArr[i][j];
                }
            }
        }
        return sparseArray;
    }


    /**
     * 将稀疏数组还原为普通二维数组
     *
     * @param sparseArray 稀疏数组
     * @return 普通二维数组
     */
    public static int[][] getTwoDimensionalArray(int[][] sparseArray) {
//        1. 先读取稀疏数组的第一行数据，创建原始的二维数组
        int[][] chessArray = new int[sparseArray[0][0]][sparseArray[0][1]];
//        2. 读取稀疏数组第二行以后的数据赋值给原始数组
        for (int i = 1; i < sparseArray.length; i++) {
            chessArray[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        return chessArray;
    }
}
