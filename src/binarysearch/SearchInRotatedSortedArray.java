package binarysearch;

/**
 *
 * You are given an array of length n which was originally sorted in ascending order. It has now been rotated between 1 and n times. For example, the array nums = [1,2,3,4,5,6] might become:
 *
 * [3,4,5,6,1,2] if it was rotated 4 times.
 * [1,2,3,4,5,6] if it was rotated 6 times.
 * Given the rotated sorted array nums and an integer target, return the index of target within nums, or -1 if it is not present.
 *
 * You may assume all elements in the sorted rotated array nums are unique,
 *
 * A solution that runs in O(n) time is trivial, can you write an algorithm that runs in O(log n) time?
 *
 */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length -1;

        while (l <= r) {
            int mid = (l+r)/2;
            if (nums[mid] == target) return mid;

            if (nums[mid] >= nums[l]) {
                if (target>= nums[l] && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (target <= nums[r] &&  target > nums[mid]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {3,4,5,6,1,2};
        SearchInRotatedSortedArray s = new SearchInRotatedSortedArray();
        System.out.println(s.search(nums, 4));
    }

}
