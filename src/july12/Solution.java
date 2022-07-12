package july12;

import java.util.ArrayList;
import java.util.List;

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
