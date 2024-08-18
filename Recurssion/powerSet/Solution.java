import java.util.ArrayList;
import java.util.List;

class Solution {
    public void helper(int idx, int[] nums, List<List<Integer>> ans, List<Integer> preAns, int n) {
        if (idx == n) {
            ans.add(new ArrayList<>(preAns)); 
            return;
        }

        preAns.add(nums[idx]); 
        helper(idx + 1, nums, ans, preAns, n); 
        preAns.remove(preAns.size() - 1); 
        helper(idx + 1, nums, ans, preAns, n); 
    }

    public List<List<Integer>> powerSet(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> preAns = new ArrayList<>();
        helper(0, nums, ans, preAns, nums.length);

        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = solution.powerSet(nums);

        
        for (List<Integer> subset : result) {
            System.out.println(subset);
        }
    }
}
