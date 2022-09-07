package scrolling_number;

import java.util.HashSet;

public class ScrollingNumbers {
    public static void main(String[] args) {
        scrollingLock(100, 500);
    }

    protected static void scrollingLock(int start, int end) {
        if (start >= end || start < 10) return;
        for (int each = start; each <= end; each++) {
            int[] arr = Integer.toString(each).chars().map(d -> d - '0').toArray();
            if (isScattingNumbers(arr)) {
                System.out.println(each);
            }
        }
    }

    /**
     * @param arr array entry to check each digit
     * @return false if the number is not valid in given range.
     * The numbers are valid when
     * No digits repeat themselves. (check current index not match with the calculated index)
     * All digits in the number "scroll" through themselves. (check no duplicate index must present )
     */
    protected static boolean isScattingNumbers(int[] arr) {
        HashSet<Integer> noDupHashSet = new HashSet<>();
        HashSet<Integer> indexSet = new HashSet<>();
        for (int val = 0; val < arr.length; val++) {
            if (arr[val] == 0) {
                return false;
            }
            int index = (arr[val] + val) % arr.length;
            if (!noDupHashSet.contains(arr[val]) && !indexSet.contains(index) && index != val) {
                noDupHashSet.add(arr[val]);
                indexSet.add(index);
            } else return false;
        }
        return true;
    }

}
