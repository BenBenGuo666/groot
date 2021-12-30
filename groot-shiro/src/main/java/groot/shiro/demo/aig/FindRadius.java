package groot.shiro.demo.aig;

import java.util.Arrays;

/**
 * @Desc 求热水器可以覆盖到所有房子的最小覆盖半径
 * @Author GuoBen~
 * @Date 2021/12/21
 */
public class FindRadius {

    public static void main(String[] args) {
        int[] s = {282475249,622650073,984943658,144108930,470211272,101027544,457850878,458777923};
        int[] x = {823564440,115438165,784484492,74243042,114807987,137522503,441282327,16531729,823378840,143542612};
        quickSort(s, 0, s.length-1);
        quickSort(x, 0, x.length-1);
        for (int i = 0; i < s.length; i++) {
            System.out.print(s[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i] + " ");
        }
        System.out.println();
        System.out.println(findRadius(s, x));
        System.out.println("预期：" + 161834419);
    }

    /**
     * 解题意知， house 与 heater 是处于一条坐标轴上的散落点，可重合，
     * 题解要求是寻找给出范围内最小热水器覆盖半径，思考几遍后破题，
     * 取坐标轴上一个 house 左右最近的俩儿个 heater 选半径较小的 length，即取最近 heater length，
     * 然后从所有 house 最小半径取最大值，返回结果。
     *
     * 优化思路，双排序之后顺序下可以更有效计算 house 最近 heater 位置，
     * 顺序下记录前一个 house 最近的 heater 位置，这样可以用到顺序模式下地缘特性，避免过多的操作指针以及运算；
     *
     * 作者：guan-bao-er
     * 链接：https://leetcode-cn.com/problems/heaters/solution/shuang-pai-xu-xia-shi-yong-shuang-zhi-zh-6p8u/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param houses
     * @param heaters
     * @return
     */
    public static int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        quickSort(heaters, 0, heaters.length -1);
        int result = 0;
        if(heaters.length == 1){
            int left = heaters[0] - houses[0];
            int right = houses[houses.length - 1] - heaters[0];
            result = (left > right)? left : right;
        }else{
            int heater_site = 0;
            for(int i = 0; i < houses.length; i ++){
                int h_length = 0;
                for(int j = heater_site; j < heaters.length; j ++){
                    int t_length = Math.max(houses[i], heaters[j])
                            - Math.min(houses[i], heaters[j]);
                    if(j == heater_site) h_length = t_length;
                    h_length = Math.min(t_length, h_length);
                    if(t_length > h_length) {
                        heater_site = j - 1;
                        break;
                    }
                }
                result = (h_length > result)? h_length : result;
            }
        }
        return result;
    }

    private static void quickSort(int[] arr, int left, int right) {
        int i, j, temp;
        if(left > right){
            return;
        }
        i = left;
        j = right;
        temp = arr[left];
        while (i < j) {
            while (temp <= arr[j] && i < j) {
                j--;
            }
            while (temp >= arr[i] && i < j) {
                i++;
            }
            if (i < j) {
                int z, y;
                z = arr[i];
                y = arr[j];
                arr[i] = y;
                arr[j] = z;
            }
        }
        arr[left] = arr[i];
        arr[i] = temp;
        quickSort(arr, left, j - 1);
        quickSort(arr, j + 1, right);
    }


}
