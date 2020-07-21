import java.util.Arrays;

/**
 * 242 有效的字母异位词
 *
 * @author Q
 */
public class IsAnagram {
    public static void main(String[] args) {
        String s = "hello";
        String t = "hello";
        System.out.println(isAnagram(s, t));
        System.out.println(isAnagramPlus(s, t));
    }

    /**
     * 排序
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();

        Arrays.sort(charS);
        Arrays.sort(charT);

        return Arrays.equals(charS, charT);
    }

    public static final int ALPHABET = 26;

    /**
     * 哈希
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagramPlus(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] all = new int[ALPHABET];

        for (int i = 0; i < s.length(); i++) {
            all[s.charAt(i) - 'a']++;
            all[t.charAt(i) - 'a']--;
        }

        for (int j = 0; j < ALPHABET; j++) {
            if (all[j] != 0) {
                return false;
            }
        }

        return true;
    }
}
