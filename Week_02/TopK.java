import java.util.*;

/**
 * 347 前k个高频元素
 *
 * @author Q
 */
public class TopK {
    public static void main(String[] args) {
        int[] nums={1,1,1,2,2,3};
        int k=2;
        System.out.println(topK(nums, k));
    }

    /**
     * 堆
     *
     * @param nums
     * @param k
     * @return
     */
    public static List<Integer> topK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n :
                nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        Queue<Integer> heap = new PriorityQueue<>((n1, n2) -> map.get(n1) - map.get(n2));
        for (int n :
                map.keySet()) {
            heap.add(n);

            if (heap.size() > k) {
                heap.poll();
            }
        }

        List<Integer> topK = new LinkedList<>();
        while (!heap.isEmpty()) {
            topK.add(heap.poll());
        }

        Collections.reverse(topK);
        return topK;
    }
}
