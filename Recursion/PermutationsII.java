package Recursion;
import java.util.*;
import java.util.stream.Collectors;

public class PermutationsII {
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        System.out.println(new PermutationsII().permuteUnique(nums));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, result, 0);
        return result;
    }

    private void helper(int[] nums, List<List<Integer>> result, int index) {
        if(index == nums.length) {
            // Use Streams API to convert array to list
            result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }

        Set<Integer> set = new HashSet<>();
        // We swap all elements to the right of index with index recursively
        for (int i = index; i < nums.length; i++) {
            // In order to keep track of which all elements have already been swapped for this postion, we keep a set
            if(set.contains(nums[i])) continue;
            else set.add(nums[i]);

            swap(nums, index, i);
            helper(nums, result, index+1);
            // backtrack the changes
            swap(nums, index, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
