#39. 组合总和

### 题目
给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
candidates 中的数字可以无限制重复被选取。

示例 1： 输入：candidates = [2,3,6,7], target = 7, 所求解集为： [ [7], [2,2,3] ]

### 思路
- 通过标题以及题意可知，问题是回溯的组合问题。
- 由递归回溯过程以及结合回溯组合问题的模板，将candidates的中每个值暴力组合。

### 代码
```
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
```
