/**
 * 860.柠檬水找零
 *
 * @author Q
 */
public class LemonadeChange {
    public static void main(String[] args) {
        int[] prices1 = {5, 5, 5, 10, 20};
        int[] prices2 = {10, 10, 20};
        System.out.println(lemonadeChange(prices2));
    }

    /**
     * 贪心算法
     * 时间复杂度:O(n) 空间复杂度:O(1)
     *
     * @param prices
     * @return
     */
    public static boolean lemonadeChange(int[] prices) {
        int five = 0, ten = 0;

        for (int price :
                prices) {
            if (price == 5) {
                five++;
            } else if (price == 10) {
                if (five == 0) {
                    return false;
                }
                ten++;
                five--;
            } else {
                //组合1:10+5
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                } else if (five >= 3) {
                    //组合2:5+5+5
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
