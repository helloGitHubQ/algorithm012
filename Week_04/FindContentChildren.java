import java.util.Arrays;

/**
 * 455.分发饼干
 *
 * @author Q
 */
public class FindContentChildren {
    public static void main(String[] args) {
        int[] g1 = {10,9,8,7}, s1 = {5,6,7,8};
        int[] g2 = {1, 2}, s2 = {1, 2, 3};
        System.out.println(findContentChildren(g1, s1));
    }

    public static int findContentChildren(int[] g, int[] s) {
        //1.排序
        Arrays.sort(g);
        Arrays.sort(s);

        int gi = 0, si = 0;

        while (gi < g.length && si < s.length) {
            if (s[si] >= g[gi]) {
                gi += 1;
            }
            si+=1;
        }

        return gi;
    }
}
