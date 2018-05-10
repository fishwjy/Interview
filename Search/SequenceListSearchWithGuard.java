import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SequenceListSearchWithGuard {
    private static int mTarget;

    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter your target integer: ");
        try {
            mTarget = Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        int result = searchInSequenceListWithGuard(readIntArray(), mTarget);
        if (result == 0) {
            System.out.println("Not found target: " + mTarget);
        } else {
            System.out.println("Found target: " + result + " ==> " + mTarget);
        }

        System.exit(0);
    }

    private static int searchInSequenceListWithGuard(int[] list, int target) {
        int i = list.length - 1;
        while (target != list[i]) {
            i--;
        }

        return i;
    }

    private static int[] readIntArray() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter your integer array: ");
        try {
            String[] arrayStr = bufferedReader.readLine().split(" ");
            int[] intArray = new int[arrayStr.length + 1];
            intArray[0] = mTarget;
            for (int i = 0; i < arrayStr.length; i++) {
                intArray[i + 1] = Integer.parseInt(arrayStr[i]);
            }
            return intArray;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}