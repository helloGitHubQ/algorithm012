import java.util.*;

/**
 * 49.字母异位词分组
 *
 * @author Q
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strings = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<Integer>> listList = groupAnagramsPlus(strings);
        for (List<Integer> list : listList) {
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + ",");
            }
            System.out.println();
        }
    }

    /**
     * 排序法
     *
     * @param strs
     * @return
     */
    public static List<List<Integer>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList();
        }

        Map<String, List> ans = new HashMap<>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!ans.containsKey(key)) {
                ans.put(key, new ArrayList());
            }

            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());

    }

    /**
     * 计数法
     *
     * @param strings
     * @return
     */
    public static List<List<Integer>> groupAnagramsPlus(String[] strings) {
        if (strings.length == 0) {
            return null;
        }

        Map<String, List> map = new HashMap<>();
        int[] count = new int[26];
        for (String s :
                strings) {
            Arrays.fill(count, 0);
            for (char c :
                    s.toCharArray()) {
                count[c - 'a']++;
            }

            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < 26; i++) {
                stringBuffer.append("#");
                stringBuffer.append(count[i]);
            }

            String key = stringBuffer.toString();

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList());
            }
            map.get(key).add(s);
        }

        return new ArrayList(map.values());
    }
}
