import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 最普通的顺序表查询
 */

public class SequenceListSearch {
    private static int mTarget;

    /**
     * 顺序查找
     *
     * @param list   待查找的顺序表
     * @param target 查找目标
     * @return 命中目标的下标，-1为没有找到
     */
    private static int searchInSequenceList(int[] list, int target) {
        for (int i = 0; i < list.length; i++) {
            if (list[i] == target) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter your target integer: ");
        try {
            mTarget = Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        int result = searchInSequenceList(readIntArray(), mTarget);
        if (result == -1) {
            System.out.println("Not found target: " + mTarget);
        } else {
            System.out.println("Found target: " + ++result + " ==> " + mTarget);
        }

        System.exit(0);
    }

    /**
     * 从终端读取整形数组
     *
     * @return 用户输入的整形数组
     */
    private static int[] readIntArray() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter your integer array: ");
        try {
            String[] arrayStr = bufferedReader.readLine().split(" ");
            int[] intArray = new int[arrayStr.length];
            for (int i = 0; i < arrayStr.length; i++) {
                intArray[i] = Integer.parseInt(arrayStr[i]);
            }
            return intArray;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}