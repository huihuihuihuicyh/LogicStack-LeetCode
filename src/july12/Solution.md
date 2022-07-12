# 131. 分割回文串

### 题目
给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。

回文串 是正着读和反着读都一样的字符串。

示例 1：

输入：s = "aab"
输出：[["a","a","b"],["aa","b"]]

### 思路
- 通过标题以及题意可知，问题是回溯的分割回文串问题。
- 由递归回溯过程以及结合回溯问题的模板，startIndex、i 这两个下标变化 来分割回文串

### 代码
```
class Solution {
    List<List<String>> res = new ArrayList<>();
    List<String> list = new ArrayList<>();
    public List<List<String>> partition(String s) {
        backTrack(s, 0);
        return res;
    }
    void backTrack(String str, int startIndex) {
        if (startIndex >= str.length()) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = startIndex; i < str.length(); i ++ ) {
            String tmp = str.substring(startIndex, i+1);
            if (!patten(tmp)) {
                continue;
            } else {
                list.add(tmp);
            }
            backTrack(str, i + 1);
            list.remove(list.size() - 1);
        }
    }
    boolean patten(String str) {
        int l = 0;
        int r = str.length() - 1;
        while (l <= r) {
            if (str.charAt(l) != str.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}

```
