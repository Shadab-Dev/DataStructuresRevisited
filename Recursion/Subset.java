package Recursion;
import java.util.*;

public class Subset {
    public static void main(String[] args) {
        int[] nums = {0};
        System.out.println(new Subset().subsets(nums));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, new ArrayList<>(), result, 0);
        return result;
    }

    public void helper(int[] nums, List<Integer> output, List<List<Integer>> result, int index) {
        if(index == nums.length) {
            // Copy the output to a new list and then add to avoid changes to added list
            result.add(new ArrayList<>(output));
            return;
        }

        output.add(nums[index]);
        helper(nums, output, result, index+1);
        // since the next recursion call does not have the index elem added, we remove it from output
        output.remove(output.size()-1);
        helper(nums, output, result, index+1);
    }
}
