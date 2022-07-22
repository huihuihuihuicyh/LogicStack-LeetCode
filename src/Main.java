import java.util.*;

public class Main {
    static List<Integer> flag = new ArrayList<>();
    static List<List<Integer>> res = new ArrayList<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        String str = "";
        String tmp = "";
        while (in.hasNextLine()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            str = in.nextLine();
            tmp = in.nextLine();
            System.out.println(str);
            System.out.println(tmp);
            break;
        }
        String[] s = str.split(",");
        for (String value : s) {
            list.add(Integer.parseInt(value));
        }
        int k = Integer.parseInt(tmp);
        backTrack(list, 0);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (List<Integer> re : res) {
            int sum = 0;
            for (Integer r : re) {
                sum += r;
            }
            map.put(sum, map.getOrDefault(sum,0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == k) {
                System.out.println(true);
            }
        }
        System.out.println(false);

    }
    static void backTrack(List<Integer> list, int index) {
        res.add(new ArrayList<>(flag));
        if (index >= list.size()) {
            return;
        }
        for (int i = index; i < list.size(); i ++ ) {
            flag.add(list.get(i));
            backTrack(list, i + 1);
            flag.remove(flag.size() - 1);
        }
    }
}
