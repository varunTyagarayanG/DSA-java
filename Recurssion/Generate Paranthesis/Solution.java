import java.util.*;

class Solution {
    public void func(String checker, int leftOpen, int rightClose, int n, List<String> ans) {
        if (leftOpen + rightClose == 2 * n && leftOpen == rightClose) {
            ans.add(checker);
            return; 
        }

        if (leftOpen < n) { 
            func(checker + "(", leftOpen + 1, rightClose, n, ans);
        }
        
        if (leftOpen > rightClose) { 
            func(checker + ")", leftOpen, rightClose + 1, n, ans);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        func("", 0, 0, n, list);
        return list;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        List<String> result1 = solution.generateParenthesis(3);
        System.out.println("n = 3: " + result1);

        List<String> result2 = solution.generateParenthesis(2);
        System.out.println("n = 2: " + result2);

        List<String> result3 = solution.generateParenthesis(1);
        System.out.println("n = 1: " + result3);

        List<String> result4 = solution.generateParenthesis(4);
        System.out.println("n = 4: " + result4);
    }
}
