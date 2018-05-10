import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 折半查找
 * 2 5 7 13 18 23 57 80 90 100
 */

public class BinarySearch {
    private static int mTarget;

    private static int binarySearch(int[] list, int target) {
        int low = 0;
        int high = list.length - 1;
        int mid = (low + high) / 2;

        while (list[mid] != target) {
            if (target < list[mid]) {
                high = mid;
            }

            if (target > list[mid]) {
                low = mid;
            }

            mid = (low + high) / 2;

            if (mid == low || mid == high) {
                if (list[low] == target) {
                    return low;
                } else if (list[high] == target) {
                    return high;
                } else {
                    return -1;
                }
            }
        }

        return mid;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter your target integer: ");
        try {
            mTarget = Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        int result = binarySearch(readIntArray(), mTarget);
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