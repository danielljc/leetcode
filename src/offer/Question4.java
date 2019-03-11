package offer;

/**
 * 面试题4：二维数组中的查找
 * 题目：在⼀个二维数组中，每一⾏都按照从左到右的递增的顺序排序，每⼀列都按照从上到下递增的顺序排序。
 * 请完成⼀个函数，输⼊这样的⼀维数组和⼀个整数，判断数组中是否含有该整数。
 */
public class Question4 {
    public static boolean Find(int target, int [][] array) {
        boolean result = false;
        int row = array.length;
        int column = array[0].length;

        int i = 0;
        int j = column - 1;
        // 核心：从右上角开始查找
        while (i < row && j >= 0) {
            if (array[i][j] == target) {
                result = true;
                break;
            } else if (array[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] array = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        System.out.println(Find(7, array));
    }
}
