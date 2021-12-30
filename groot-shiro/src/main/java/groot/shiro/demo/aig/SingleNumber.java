package groot.shiro.demo.aig;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Desc
 * @Author GuoBen~
 * @Date 2021/12/21
 */
public class SingleNumber {

    public static void main(String[] args) {
        Math.max(2,3);
    }

    public int singleNumber(int[] nums) {
        int singleNumber = 0;
        /*
        // Map 解法 6ms
        Map<Integer, Integer> maps = new HashMap<>();
        for(int i : nums){
            maps.put(i, maps.getOrDefault(i,0) + 1);
        }
        for(Integer e : maps.keySet()){
            if(maps.get(e) == 1){
                singleNumber = maps.get(e);
            }
        }*/

        /**
         * 电路门设计解题
         */
        int a=0,b=0;

        for(int num:nums){
            a=~b&(a^num);
            b=~a&(b^num);

        }
        return a;

        /*Arrays.sort(nums);
        for(int i = 0; i < nums.length; i ++){
            if((i + 1) < nums.length && nums[i] == nums[i + 1]){
                i += 2;
                continue;
            }else {
                singleNumber = nums[i];
            }
        }*/
//        return singleNumber;
    }

}
