package binarysearch;

public class BinarySearch {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length-1;

        while (l < r) {
            int mid = (l + r)/2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch b = new BinarySearch();
        int[] arr = {-1,0,3,5,9,12};
        int target = 9;
        System.out.println(b.search(arr, target));
    }
}
