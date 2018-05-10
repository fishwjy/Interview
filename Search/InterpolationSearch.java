import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 插值查找
 * 2 5 7 13 18 23 57 80 90 100
 */

public class InterpolationSearch {
    private static int mTarget;

    /**
     * 插值查找
     *
     * @param list   待查找的有序表
     * @param target 查找目标
     * @return 命中目标的下标，-1为没有找到
     */
    private static int interpolationSearch(int[] list, int target) {
        int low, mid, high;
        low = 0;
        high = list.length - 1;

        while (low <= high) {
//            mid = (low + high) / 2;
            /* 插值，与折半查找仅此一行区别*/
            mid = low + (high -low) * (target - list[low]) / (list[high] - list[low]);
            if (target < list[mid]) {
                high = mid - 1;
            } else if (target > list[mid]) {
                low = mid + 1;
            } else {
                return mid;
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

        int result = interpolationSearch(readIntArray(), mTarget);
        if (result == -1) {
            System.out.println("Not found the target: " + mTarget);
        } else {
            System.out.println("Found target: " + ++result + " ==> " + mTarget);
        }

        System.exit(0);
    }

    /**
     * 从终端读取整形数组
     *
     * @return 用户输入的整形数组整形数组
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
