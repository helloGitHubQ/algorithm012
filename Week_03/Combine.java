import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 77.组合
 *
 * @author Q
 */
public class Combine {
    public static void main(String[] args) {
        List<List<Integer>> result = combine(n, k);
        System.out.println(result);
    }

    /**
     * 回溯
     *
     * @param n
     * @param k
     * @return
     */
    private static List<List<Integer>> output = new ArrayList<>();
    private static int n = 4, k = 2;

    public static List<List<Integer>> combine(int n, int k) {
        backtrack(1, new LinkedList<>());
        return output;
    }

    private static void backtrack(int first, LinkedList<Integer> curr) {
        if(curr.size()==k){
            output.add(new LinkedList<>(curr));
        }

        for (int i=first;i<n+1;i++){
            curr.add(i);

            backtrack(i+1,curr);

            curr.removeLast();
        }
    }
}
