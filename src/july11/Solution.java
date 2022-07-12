package july11;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        Solution solution = new Solution();
        solution.combinationSum(candidates, target);
        System.out.println(solution.res);
    }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backTrack(candidates, target, 0);
        return res;
    }
    void backTrack(int[] candidates, int target, int startIndex) {
        int sum = 0;
        for (int i : list) sum += i;
        if (sum > target) return;
        if (sum == target) res.add(new ArrayList<Integer>(list));
        // 单层递归逻辑
        for (int i = startIndex; i < candidates.length; i ++ ) {
            list.add(candidates[i]);
            backTrack(candidates, target, i);
            list.remove(list.size() - 1);
        }
    }
}
