import java.util.ArrayList;
import java.util.List;

class Solution {
    public void helper(int idx, int[] nums, int sum, List<Integer> preAns, List<List<Integer>> ans) {
        if (sum == 0) {
            ans.add(new ArrayList<>(preAns));
            return;
        }
        if (sum < 0 || idx >= nums.length) {
            return;
        }

        preAns.add(nums[idx]);
        helper(idx, nums, sum - nums[idx], preAns, ans);
        
        preAns.remove(preAns.size() - 1);
        helper(idx + 1, nums, sum, preAns, ans);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> preAns = new ArrayList<>();

        helper(0, candidates, target, preAns, ans);

        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        
        List<List<Integer>> result = solution.combinationSum(candidates, target);
        System.out.println("Combinations that sum to " + target + ": " + result);
    }
}
